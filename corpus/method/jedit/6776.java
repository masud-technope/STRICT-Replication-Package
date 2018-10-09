//}}}
//{{{ setBorder() method
/**
	 * Convenience method for setting a default matte border on the right
	 * with the specified border width and color
	 * @param width The border width (in pixels)
	 * @param color1 The focused border color
	 * @param color2 The unfocused border color
	 * @param color3 The gutter/text area gap color
	 */
public void setBorder(int width, Color color1, Color color2, Color color3) {
    borderWidth = width;
    focusBorder = new CompoundBorder(new MatteBorder(0, 0, 0, width, color3), new MatteBorder(0, 0, 0, width, color1));
    noFocusBorder = new CompoundBorder(new MatteBorder(0, 0, 0, width, color3), new MatteBorder(0, 0, 0, width, color2));
    updateBorder();
}