//{{{ prettifyMenuLabel() method
/**
	 * `Prettifies' a menu item label by removing the `$' sign. This
	 * can be used to process the contents of an <i>action</i>.label
	 * property.
	 * @param label the label
	 * @return a pretty label
	 * @since jEdit 5.3.1
	 */
public static String prettifyMenuLabel(String label) {
    int index = label.indexOf('$');
    if (index != -1) {
        label = label.substring(0, index).concat(label.substring(index + 1));
    }
    return label;
}