//}}}
//{{{ actionPerformed() method
public void actionPerformed(ActionEvent evt) {
    if (jEdit.getIntegerProperty("autosave", 0) == 0)
        return;
    // save list of open files
    if (jEdit.getViewCount() != 0 && PerspectiveManager.isPerspectiveDirty()) {
        PerspectiveManager.setPerspectiveDirty(false);
        PerspectiveManager.savePerspective(true);
    }
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    Buffer[] bufferArray = jEdit.getBuffers();
    for (Buffer buffer : bufferArray) {
        if (autosaveUntitled || !buffer.isUntitled())
            buffer.autosave();
    }
    // flush log
    Log.flushStream();
}