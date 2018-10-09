//}}}
//{{{ stopRecording() method
/**
	 * Stops a recording currently in progress.
	 * @param view The view
	 * @since jEdit 2.7pre2
	 */
public static void stopRecording(View view) {
    Recorder recorder = view.getMacroRecorder();
    if (recorder == null)
        GUIUtilities.error(view, "macro-not-recording", null);
    else {
        view.setMacroRecorder(null);
        if (!recorder.temporary)
            view.setBuffer(recorder.buffer);
        recorder.dispose();
    }
}