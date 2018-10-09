//}}}
//{{{ getStringWidth() method
/**
	 * Returns the width of the given string, in pixels, using the text
	 * area's current font.
	 *
	 * @since jEdit 4.2final
	 */
public float getStringWidth(String str) {
    if (textArea.charWidth != 0)
        return textArea.charWidth * str.length();
    else {
        return (float) getFont().getStringBounds(str, getFontRenderContext()).getWidth();
    }
}