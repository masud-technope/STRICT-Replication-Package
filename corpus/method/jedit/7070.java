//}}}
//{{{ expandFold() method
/**
	 * Like {@link DisplayManager#expandFold(int,boolean)}, but
	 * also moves the caret to the first sub-fold.
	 * @param fully If true, all subfolds will also be expanded
	 * @since jEdit 4.0pre3
	 */
public void expandFold(boolean fully) {
    int x = chunkCache.subregionOffsetToX(caretLine, caret - getLineStartOffset(caretLine));
    int line = displayManager.expandFold(caretLine, fully);
    if (!fully && line != -1) {
        if (!multi)
            selectNone();
        moveCaretPosition(getLineStartOffset(line) + chunkCache.xToSubregionOffset(line, 0, x, true));
    }
}