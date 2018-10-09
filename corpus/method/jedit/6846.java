//}}}
//{{{ addExplicitFold() method
/**
	 * Surrounds the selection with explicit fold markers.
	 * @since jEdit 4.0pre3
	 */
@Override
public void addExplicitFold() {
    try {
        super.addExplicitFold();
    } catch (TextAreaException e) {
        GUIUtilities.error(view, "folding-not-explicit", null);
    }
}