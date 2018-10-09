//}}}
//{{{ removeLeftOfScrollBar() method
/**
	 * Removes a component from the box left of the vertical scroll bar.
	 *
	 * @param comp The component
	 * @since jEdit 4.2pre1
	 */
public void removeLeftOfScrollBar(Component comp) {
    verticalBox.remove(comp);
}