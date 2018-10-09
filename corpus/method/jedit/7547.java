//}}}
//{{{
/**
 	 * Makes components the same size by finding the largest width and height of the
 	 * given components then setting all components to that width and height. This is
 	 * especially useful for making JButtons the same size.
 	 * @param components The components to make the same size.
	 * @since jEdit 5.3.1
 	 */
public static void makeSameSize(Component... components) {
    if (components == null)
        return;
    int width = 0;
    int height = 0;
    for (Component component : components) {
        if (component == null)
            continue;
        width = Math.max(width, component.getPreferredSize().width);
        height = Math.max(height, component.getPreferredSize().height);
    }
    Dimension d = new Dimension(width, height);
    for (Component component : components) {
        if (component == null)
            continue;
        component.setPreferredSize(d);
    }
}