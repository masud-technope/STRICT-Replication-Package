//}}}
//{{{
/**
 	 * Makes components the same size by finding the largest width and height of the
 	 * given components then setting all components to that width and height. This is
 	 * especially useful for making JButtons the same size.
 	 * @param components The components to make the same size.
 	 * @deprecated use {@link GenericGUIUtilities#makeSameSize(Component...)}
 	 */
public static void makeSameSize(Component... components) {
    GenericGUIUtilities.makeSameSize(components);
}