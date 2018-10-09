//}}}
//}}}
//{{{ AWT stuff
//{{{ addLeftOfScrollBar() method
/**
	 * Adds a component to the left side of the box left of the vertical
	 * scroll bar. The ErrorList plugin uses this to show a global error
	 * overview, for example.  It is possible for more than one component
	 * to be added, each is added to the left side of the box in turn.
	 * Adding to the left ensures the scrollbar is always right of all added
	 * components.
	 *
	 * @param comp The component
	 * @since jEdit 4.2pre1
	 */
public void addLeftOfScrollBar(Component comp) {
    verticalBox.add(comp, 0);
}