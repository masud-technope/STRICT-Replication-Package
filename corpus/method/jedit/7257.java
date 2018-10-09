//}}}
//{{{ addTopLeftComponent() method
/**
	 * Adds a component above the gutter.
	 *
	 * @since jEdit 5.2pre1
	 */
public void addTopLeftComponent(Component comp) {
    add(ScrollLayout.TOP_LEFT, comp);
}