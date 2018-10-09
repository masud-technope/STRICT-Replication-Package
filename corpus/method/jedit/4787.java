//}}}
//}}}
//{{{ Buffer management methods
//{{{ closeBuffer() method
/**
	 * Closes a buffer. If there are unsaved changes, the user is
	 * prompted if they should be saved first.
	 * @param view The view
	 * @param buffer The buffer
	 * @return True if the buffer was really closed, false otherwise
	 */
public static boolean closeBuffer(View view, Buffer buffer) {
    // Wait for pending I/O requests
    if (buffer.isPerformingIO()) {
        TaskManager.instance.waitForIoTasks();
        if (VFSManager.errorOccurred())
            return false;
    }
    boolean doNotSave = false;
    if (buffer.isDirty()) {
        if (buffer.isUntitled() && jEdit.getBooleanProperty("suppressNotSavedConfirmUntitled")) {
            _closeBuffer(view, buffer, true);
            return true;
        }
        Object[] args = { buffer.getName() };
        int result = GUIUtilities.confirm(view, "notsaved", args, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (!buffer.save(view, null, true))
                return false;
            TaskManager.instance.waitForIoTasks();
            if (buffer.getBooleanProperty(BufferIORequest.ERROR_OCCURRED)) {
                return false;
            }
        } else if (result != JOptionPane.NO_OPTION) {
            // cancel
            return false;
        } else if (result == JOptionPane.NO_OPTION) {
            // when we close an untitled buffer, cos we do not want to save it by answering No,
            // mark to delete the autosave file
            doNotSave = true;
        }
    }
    _closeBuffer(view, buffer, doNotSave);
    return true;
}