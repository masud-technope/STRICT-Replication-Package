//}}}
//{{{ addTopRightComponent() method
/**
	 * Adds a component above the vertical scroll bar.
	 *
	 * @since jEdit 5.2pre1
	 */
public void addTopRightComponent(Component comp) {
    add(ScrollLayout.TOP_RIGHT, comp);
}