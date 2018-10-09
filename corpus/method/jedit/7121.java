//}}}
//{{{ getSelectedText() methods
/**
	 * Returns the text in the specified selection.
	 * @param s The selection
	 * @since jEdit 3.2pre1
	 */
public String getSelectedText(Selection s) {
    StringBuilder buf = new StringBuilder(s.end - s.start);
    s.getText(buffer, buf);
    return buf.toString();
}