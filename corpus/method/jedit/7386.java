//}}}
//{{{ setSelectionFgColorEnabled() method
/**
	 * Enables or disables selection foreground color.
	 * @param selectionFg True if selection foreground should be enabled,
	 * false otherwise
	 * @since jEdit 4.4.1
	 */
public final void setSelectionFgColorEnabled(boolean selectionFg) {
    this.selectionFg = selectionFg;
    textArea.repaint();
}