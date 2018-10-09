//}}}
//{{{ invalidateSelectedLines() method
/**
	 * Repaints the lines containing the selection.
	 */
private void invalidateSelectedLines() {
    // to hide line highlight if selections are being added later on
    invalidateLine(caretLine);
    for (Selection s : selectionManager.selection) invalidateLineRange(s.startLine, s.endLine);
}