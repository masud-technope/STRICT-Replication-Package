//}}}
//{{{ getView() method
/**
	 * Finds the view parent of the specified component.
	 * @param comp the component from which you want to get the parent view
	 * @return the parent view, or null if the component was not in a View.
	 * @since jEdit 4.0pre2
	 */
public static View getView(Component comp) {
    return (View) getComponentParent(comp, View.class);
}