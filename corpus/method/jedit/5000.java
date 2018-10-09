//}}}
//{{{ recordTemporaryMacro() method
/**
	 * Starts recording a temporary macro.
	 * @param view The view
	 * @since jEdit 2.7pre2
	 */
public static void recordTemporaryMacro(View view) {
    String settings = jEdit.getSettingsDirectory();
    if (settings == null) {
        GUIUtilities.error(view, "no-settings", new String[0]);
        return;
    }
    if (view.getMacroRecorder() != null) {
        GUIUtilities.error(view, "already-recording", new String[0]);
        return;
    }
    Buffer buffer = jEdit.openFile((View) null, settings + File.separator + "macros", "Temporary_Macro.bsh", true, null);
    if (buffer == null)
        return;
    buffer.remove(0, buffer.getLength());
    buffer.insert(0, jEdit.getProperty("macro.temp.header"));
    recordMacro(view, buffer, true);
}