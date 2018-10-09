//}}}
//{{{ saveAllBuffers() method
/**
	 * Saves all open buffers.
	 * @param view The view
	 * @since jEdit 4.2pre1
	 */
public static void saveAllBuffers(View view) {
    saveAllBuffers(view, jEdit.getBooleanProperty("confirmSaveAll"));
}