//}}}
//{{{ Scrolling
//{{{ getFirstLine() method
/**
	 * Returns the vertical scroll bar position.
	 * @since jEdit 4.2pre1
	 */
public final int getFirstLine() {
    return displayManager.firstLine.getScrollLine() + displayManager.firstLine.getSkew();
}