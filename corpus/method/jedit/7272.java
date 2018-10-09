/**
	 * Returns the text in all active selections.
	 * @param separator The string to insert between each text chunk
	 * (for example, a newline)
	 * @since jEdit 3.2pre1
	 */
public String getSelectedText(String separator) {
    Selection[] sel = selectionManager.getSelection();
    if (sel.length == 0)
        return null;
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < sel.length; i++) {
        if (i != 0)
            buf.append(separator);
        sel[i].getText(buffer, buf);
    }
    return buf.toString();
}