//}}}
//{{{ recordMacro() method
/**
	 * Starts recording a macro.
	 * @param view The view
	 * @param buffer The buffer to record to
	 * @param temporary True if this is a temporary macro
	 * @since jEdit 3.0pre5
	 */
private static void recordMacro(View view, Buffer buffer, boolean temporary) {
    view.setMacroRecorder(new Recorder(view, buffer, temporary));
    // setting the message to 'null' causes the status bar to check
    // if a recording is in progress
    view.getStatus().setMessage(null);
}