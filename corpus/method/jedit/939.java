//}}}
//{{{ ok() method
@Override
public void ok() {
    VFSFile[] files = browser.getSelectedFiles();
    filename = filenameField.getText();
    boolean choosingDir = (browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG);
    if (files.length != 0) {
        if (choosingDir) {
            isOK = true;
            dispose();
        } else
            browser.filesActivated(VFSBrowser.M_OPEN, false);
        return;
    } else if (choosingDir && (filename == null || filename.length() == 0)) {
        isOK = true;
        dispose();
        return;
    } else if (filename == null || filename.length() == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    String bufferDir = browser.getView().getBuffer().getDirectory();
    if (filename.equals("-"))
        filename = bufferDir;
    else if (filename.startsWith("-/") || filename.startsWith('-' + File.separator)) {
        filename = MiscUtilities.constructPath(bufferDir, filename.substring(2));
    }
    final int[] type = { -1 };
    filename = MiscUtilities.expandVariables(filename);
    final String path = MiscUtilities.constructPath(browser.getDirectory(), filename);
    final VFS vfs = VFSManager.getVFSForPath(path);
    Object session = vfs.createVFSSession(path, this);
    if (session == null)
        return;
    ThreadUtilities.runInBackground(new GetFileTypeRequest(vfs, session, path, type));
    AwtRunnableQueue.INSTANCE.runAfterIoTasks(new Runnable() {

        public void run() {
            switch(type[0]) {
                case VFSFile.FILE:
                    if (browser.getMode() == VFSBrowser.CHOOSE_DIRECTORY_DIALOG)
                        break;
                    if (vfs instanceof FileVFS) {
                        if (doFileExistsWarning(path))
                            break;
                    }
                    isOK = true;
                    if (browser.getMode() == VFSBrowser.BROWSER_DIALOG) {
                        Hashtable<String, Object> props = new Hashtable<String, Object>();
                        if (browser.currentEncoding != null) {
                            props.put(JEditBuffer.ENCODING, browser.currentEncoding);
                        }
                        jEdit.openFile(browser.getView(), browser.getDirectory(), path, false, props);
                    }
                    dispose();
                    break;
                case VFSFile.DIRECTORY:
                case VFSFile.FILESYSTEM:
                    browser.setDirectory(path);
                    break;
            }
        }
    });
}