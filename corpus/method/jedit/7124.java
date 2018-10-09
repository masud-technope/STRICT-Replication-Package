//}}}
//{{{ setMagicCaretPosition() method
/**
	 * Sets the `magic' caret position. This can be used to preserve
	 * the column position when moving up and down lines.
	 * @param magicCaret The magic caret position
	 * @since jEdit 4.2pre1
	 */
public void setMagicCaretPosition(int magicCaret) {
    this.magicCaret = magicCaret;
}