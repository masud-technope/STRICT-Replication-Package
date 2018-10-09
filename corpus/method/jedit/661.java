//{{{ evalSelection() method
/**
	 * Evaluates the text selected in the specified text area.
	 * @param view The view
	 * @param textArea The text area
	 * @since jEdit 2.7pre2
	 */
public static void evalSelection(View view, JEditTextArea textArea) {
    bsh.evalSelection(view, textArea);
}