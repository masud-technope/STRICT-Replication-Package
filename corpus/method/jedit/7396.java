//}}}
//{{{ getLineHeight() method
/**
	 * Returns the line height as given by the font metrics plus the
	 * added line spacing.
	 */
public int getLineHeight() {
    return fm.getHeight() + extraLineSpacing;
}