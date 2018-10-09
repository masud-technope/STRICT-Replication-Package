//}}}
//{{{ prettifyMenuLabel() method
/**
	 * `Prettifies' a menu item label by removing the `$' sign. This
	 * can be used to process the contents of an <i>action</i>.label
	 * property.
	 * @param label the label
	 * @return a pretty label
	 * @deprecated use {@link GenericGUIUtilities#prettifyMenuLabel(String)}
	 */
public static String prettifyMenuLabel(String label) {
    return GenericGUIUtilities.prettifyMenuLabel(label);
}