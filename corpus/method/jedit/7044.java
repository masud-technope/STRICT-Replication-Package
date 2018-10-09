//}}}
//{{{ setMultipleSelectionEnabled() method
/**
	 * Set multiple selection on or off according to the value of
	 * <code>multi</code>. This only affects the ability to
	 * make multiple selections in the user interface; macros and plugins
	 * can manipulate them regardless of the setting of this flag. In fact,
	 * in most cases, calling this method should not be necessary.
	 *
	 * @param multi Should multiple selection be enabled?
	 * @since jEdit 3.2pre1
	 */
public final void setMultipleSelectionEnabled(boolean multi) {
    this.multi = multi;
    fireStatusChanged(StatusListener.MULTI_SELECT_CHANGED, multi);
    painter.repaint();
}