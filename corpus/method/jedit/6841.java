//}}}
//{{{ formatParagraph() method
/**
	 * Formats the paragraph containing the caret.
	 * @since jEdit 2.7pre2
	 */
@Override
public void formatParagraph() {
    try {
        super.formatParagraph();
    } catch (TextAreaException e) {
        GUIUtilities.error(view, "format-maxlinelen", null);
    }
}