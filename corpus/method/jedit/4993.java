//}}}
//{{{ runTemporaryMacro() method
/**
	 * Runs the temporary macro.
	 * @param view The view
	 * @since jEdit 2.7pre2
	 */
public static void runTemporaryMacro(View view) {
    String settings = jEdit.getSettingsDirectory();
    if (settings == null) {
        GUIUtilities.error(view, "no-settings", null);
        return;
    }
    String path = MiscUtilities.constructPath(jEdit.getSettingsDirectory(), "macros", "Temporary_Macro.bsh");
    if (jEdit.getBuffer(path) == null) {
        GUIUtilities.error(view, "no-temp-macro", null);
        return;
    }
    Handler handler = getHandler("beanshell");
    Macro temp = handler.createMacro(path, path);
    Buffer buffer = view.getBuffer();
    try {
        buffer.beginCompoundEdit();
        temp.invoke(view);
    } finally {
        /* I already wrote a comment expaining this in
			 * Macro.invoke(). */
        if (buffer.insideCompoundEdit())
            buffer.endCompoundEdit();
    }
}