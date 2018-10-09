//}}}
//{{{ Selection
//{{{ selectAll() method
/**
	 * Selects all text in the buffer. Preserves the scroll position.
	 */
public final void selectAll() {
    int firstLine = getFirstLine();
    int horizOffset = getHorizontalOffset();
    setSelection(new Selection.Range(0, buffer.getLength()));
    moveCaretPosition(buffer.getLength(), true);
    setFirstLine(firstLine);
    setHorizontalOffset(horizOffset);
}