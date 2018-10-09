//}}}
//{{{ recoverAutosave() method
private boolean recoverAutosave(final View view) {
    if (!autosaveFile.canRead())
        return false;
    // this method might get called at startup
    GUIUtilities.hideSplashScreen();
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    final Object[] args = { autosaveFile.getPath() };
    int result;
    // if it was an untitled autosave, recover without question
    if (isUntitled() && autosaveUntitled) {
        VFSManager.getFileVFS().load(view, this, autosaveFile.getPath(), isUntitled());
        return true;
    } else {
        result = GUIUtilities.confirm(view, "autosave-found", args, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }
    if (result == JOptionPane.YES_OPTION) {
        VFSManager.getFileVFS().load(view, this, autosaveFile.getPath(), isUntitled());
        // show this message when all I/O requests are
        // complete
        AwtRunnableQueue.INSTANCE.runAfterIoTasks(new Runnable() {

            public void run() {
                GUIUtilities.message(view, "autosave-loaded", args);
            }
        });
        return true;
    } else
        return false;
}