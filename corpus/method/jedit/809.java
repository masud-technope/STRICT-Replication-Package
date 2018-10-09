//}}}
//{{{ delete() method
/**
	 * Note that all files must be on the same VFS.
	 * @since jEdit 4.3pre2
	 */
public void delete(VFSFile[] files) {
    String dialogType;
    if (MiscUtilities.isURL(files[0].getDeletePath()) && FavoritesVFS.PROTOCOL.equals(MiscUtilities.getProtocolOfURL(files[0].getDeletePath()))) {
        dialogType = "vfs.browser.delete-favorites";
    } else {
        dialogType = "vfs.browser.delete-confirm";
    }
    String typeStr = "files";
    for (VFSFile file : files) {
        if (file.getType() == VFSFile.DIRECTORY) {
            typeStr = "directories and their contents";
            break;
        }
    }
    // In the previous version the first argument was the file list, now it is a list so the file list is not
    // created anymore. But for compatibility an empty string is used.
    Object[] args = { "", typeStr };
    JList<VFSFile> list = new JList<VFSFile>(files);
    list.setVisibleRowCount(10);
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(new JScrollPane(list));
    panel.add(new JLabel(jEdit.getProperty(dialogType + ".message", args)), BorderLayout.PAGE_START);
    int result = JOptionPane.showConfirmDialog(this, panel, jEdit.getProperty(dialogType + ".title"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result != JOptionPane.YES_OPTION)
        return;
    VFS vfs = VFSManager.getVFSForPath(files[0].getDeletePath());
    if (!startRequest())
        return;
    final CountDownLatch latch = new CountDownLatch(files.length);
    for (int i = 0; i < files.length; i++) {
        Object session = vfs.createVFSSession(files[i].getDeletePath(), this);
        if (session == null) {
            latch.countDown();
            continue;
        }
        final Task task = new DeleteBrowserTask(this, session, vfs, files[i].getDeletePath());
        TaskManager.instance.addTaskListener(new TaskAdapter() {

            @Override
            public void done(Task t) {
                if (task == t) {
                    latch.countDown();
                    TaskManager.instance.removeTaskListener(this);
                }
            }
        });
        ThreadUtilities.runInBackground(task);
    }
    try {
        latch.await();
    } catch (InterruptedException e) {
        Log.log(Log.ERROR, this, e, e);
    }
    Runnable delayedAWTRequest = new DelayedEndRequest();
    EventQueue.invokeLater(delayedAWTRequest);
}