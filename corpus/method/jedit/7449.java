//}}}
//{{{ confirmToCloseDirty() methods
/**
	 * If the view contains dirty buffers which will be closed on
	 * closing the view, show the confirmation dialog for user.
	 * @return
	 * 	true if there are no such buffers or user select OK
	 * 	to close the view; false if user select Cancel
	 */
boolean confirmToCloseDirty() {
    boolean autosaveUntitled = jEdit.getBooleanProperty("autosaveUntitled");
    boolean suppressNotSavedConfirmUntitled = jEdit.getBooleanProperty("suppressNotSavedConfirmUntitled") || autosaveUntitled;
    Set<Buffer> checkingBuffers = getOpenBuffers();
    for (View view : jEdit.getViews()) {
        if (view != this) {
            checkingBuffers.removeAll(view.getOpenBuffers());
        }
    }
    for (Buffer buffer : checkingBuffers) {
        if (buffer.isDirty() && !(buffer.isUntitled() && suppressNotSavedConfirmUntitled)) {
            return new CloseDialog(this, checkingBuffers).isOK();
        }
    }
    return true;
}