//}}}
//{{{ getMagicCaretPosition() method
/**
	 * Returns an internal position used to keep the caret in one
	 * column while moving around lines of varying lengths.
	 * @since jEdit 4.2pre1
	 */
public int getMagicCaretPosition() {
    if (magicCaret == -1) {
        magicCaret = chunkCache.subregionOffsetToX(caretLine, caret - getLineStartOffset(caretLine));
    }
    return magicCaret;
}