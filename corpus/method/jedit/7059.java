//}}}
//{{{ setRectangularSelectionEnabled() method
/**
	 * Set rectangular selection on or off according to the value of
	 * <code>rectangularSelectionMode</code>. This only affects the ability
	 * to make multiple selections from the keyboard. A rectangular
	 * selection can always be created by dragging with the mouse by holding
	 * down <b>Control</b>, regardless of the state of this flag.
	 *
	 * @param rectangularSelectionMode Should rectangular selection be
	 * enabled?
	 * @since jEdit 4.2pre1
	 */
public final void setRectangularSelectionEnabled(boolean rectangularSelectionMode) {
    this.rectangularSelectionMode = rectangularSelectionMode;
    fireStatusChanged(StatusListener.RECT_SELECT_CHANGED, rectangularSelectionMode);
    painter.repaint();
}