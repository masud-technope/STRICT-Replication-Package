//}}}
//{{{ addTopComponent() method
/**
	 * Adds a component above the gutter, text area, and vertical scroll bar.
	 *
	 * @since jEdit 4.2pre3
	 */
public void addTopComponent(Component comp) {
    add(ScrollLayout.TOP, comp);
}