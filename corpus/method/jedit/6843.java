//}}}
//{{{ showWordCountDialog() method
/**
	 * Displays the 'word count' dialog box.
	 * @since jEdit 2.7pre2
	 */
public void showWordCountDialog() {
    String selection = getSelectedText();
    if (selection != null) {
        doWordCount(view, selection);
        return;
    }
    doWordCount(view, buffer.getText(0, buffer.getLength()));
}