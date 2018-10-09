//}}}
//{{{ getStyleString() method
/**
	 * Converts a style into it's string representation.
	 * @param style The style
	 */
public static String getStyleString(SyntaxStyle style) {
    StringBuilder buf = new StringBuilder();
    if (style.getForegroundColor() != null) {
        buf.append("color:").append(SyntaxUtilities.getColorHexString(style.getForegroundColor()));
    }
    if (style.getBackgroundColor() != null) {
        buf.append(" bgColor:").append(SyntaxUtilities.getColorHexString(style.getBackgroundColor()));
    }
    Font font = style.getFont();
    if (!font.isPlain()) {
        buf.append(" style:");
        if (font.isItalic())
            buf.append('i');
        if (font.isBold())
            buf.append('b');
    }
    return buf.toString();
}