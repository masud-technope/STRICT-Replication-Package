//}}}
//{{{ setBlockCaretEnabled() method
/**
	 * Sets if the caret should be drawn as a block, false otherwise.
	 * @param blockCaret True if the caret should be drawn as a block,
	 * false otherwise.
	 */
public final void setBlockCaretEnabled(boolean blockCaret) {
    this.blockCaret = blockCaret;
    extensionMgr.removeExtension(caretExtension);
    if (blockCaret)
        addExtension(BLOCK_CARET_LAYER, caretExtension);
    else
        addExtension(CARET_LAYER, caretExtension);
    if (textArea.getBuffer() != null)
        textArea.invalidateLine(textArea.getCaretLine());
}