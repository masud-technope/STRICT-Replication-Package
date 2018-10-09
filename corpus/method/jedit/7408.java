//}}}
//{{{ setWrapGuidePainted() method
/**
	 * Sets if the wrap guide is to be drawn.
	 * @param wrapGuide True if the wrap guide should be drawn, false otherwise
	 */
public final void setWrapGuidePainted(boolean wrapGuide) {
    this.wrapGuide = wrapGuide;
    repaint();
}