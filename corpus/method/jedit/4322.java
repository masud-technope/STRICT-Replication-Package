//}}}
//{{{ inputProperty() method
/**
	 * Displays an input dialog box and returns any text the user entered.
	 * The title of the dialog is fetched from
	 * the <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param def The property whose text to display in the input field
	 */
public static String inputProperty(Component comp, String name, String def) {
    return inputProperty(comp, name, null, def);
}