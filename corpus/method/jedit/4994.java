//}}}
//{{{ recordMacro() method
/**
	 * Starts recording a macro.
	 * @param view The view
	 * @since jEdit 2.7pre2
	 */
public static void recordMacro(View view) {
    String settings = jEdit.getSettingsDirectory();
    if (settings == null) {
        GUIUtilities.error(view, "no-settings", new String[0]);
        return;
    }
    if (view.getMacroRecorder() != null) {
        GUIUtilities.error(view, "already-recording", new String[0]);
        return;
    }
    String name = GUIUtilities.input(view, "record", null);
    if (name == null)
        return;
    name = name.replace(' ', '_');
    Buffer buffer = jEdit.openFile((View) null, null, MiscUtilities.constructPath(settings, "macros", name + ".bsh"), true, null);
    if (buffer == null)
        return;
    buffer.remove(0, buffer.getLength());
    buffer.insert(0, jEdit.getProperty("macro.header"));
    recordMacro(view, buffer, false);
}