//}}}
//{{{ checkBufferStatus() methods
/**
	 * Checks each buffer's status on disk and shows the dialog box
	 * informing the user that buffers changed on disk, if necessary.
	 * @param view The view
	 * @since jEdit 4.2pre1
	 */
public static void checkBufferStatus(View view) {
    checkBufferStatus(view, false);
}