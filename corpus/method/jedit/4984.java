//{{{ showRunScriptDialog() method
/**
	 * Prompts for one or more files to run as macros
	 * @param view The view
	 * @since jEdit 4.0pre7
	 */
public static void showRunScriptDialog(View view) {
    String[] paths = GUIUtilities.showVFSFileDialog(view, null, JFileChooser.OPEN_DIALOG, true);
    if (paths != null) {
        Buffer buffer = view.getBuffer();
        try {
            buffer.beginCompoundEdit();
            for (String path : paths) runScript(view, path, false);
        } finally {
            buffer.endCompoundEdit();
        }
    }
}