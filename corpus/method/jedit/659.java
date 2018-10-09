//}}}
//{{{ showEvaluateLinesDialog() method
/**
	 * Evaluates the specified script for each selected line.
	 * @param view The view
	 * @since jEdit 4.0pre1
	 */
public static void showEvaluateLinesDialog(View view) {
    String command = GUIUtilities.input(view, "beanshell-eval-line", null);
    JEditTextArea textArea = view.getTextArea();
    Buffer buffer = view.getBuffer();
    if (command == null || command.length() == 0)
        return;
    Selection[] selection = textArea.getSelection();
    if (selection.length == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (!command.endsWith(";"))
        command = command + ";";
    String script = "int[] lines = textArea.getSelectedLines();\n" + "for(int i = 0; i < lines.length; i++)\n" + "{\n" + "line = lines[i];\n" + "index = line - lines[0];\n" + "start = buffer.getLineStartOffset(line);\n" + "end = buffer.getLineEndOffset(line);\n" + "text = buffer.getText(start,end - start - 1);\n" + "newText = " + command + "\n" + "if(newText != null)\n" + "{\n" + "buffer.remove(start,end - start - 1);\n" + "buffer.insert(start,String.valueOf(newText));\n" + "}\n" + "}\n";
    if (view.getMacroRecorder() != null)
        view.getMacroRecorder().record(1, script);
    try {
        buffer.beginCompoundEdit();
        bsh.eval(view, script);
    } finally {
        buffer.endCompoundEdit();
    }
    textArea.selectNone();
}