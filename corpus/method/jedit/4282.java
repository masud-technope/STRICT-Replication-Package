//}}}
//{{{ inputProperty() method
/**
	 * Displays an input dialog box and returns any text the user entered.
	 * The title of the dialog is fetched from
	 * the <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param args Positional parameters to be substituted into the
	 * message text
	 * @param def The property whose text to display in the input field
	 * @since jEdit 3.1pre3
	 */
public static String inputProperty(final Component comp, final String name, final Object[] args, final String def) {
    if (EventQueue.isDispatchThread()) {
        hideSplashScreen();
        String retVal = (String) JOptionPane.showInputDialog(comp, jEdit.getProperty(name.concat(".message"), args), jEdit.getProperty(name.concat(".title")), JOptionPane.QUESTION_MESSAGE, null, null, jEdit.getProperty(def));
        if (retVal != null)
            jEdit.setProperty(def, retVal);
        return retVal;
    }
    final String[] retValue = new String[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = inputProperty(comp, name, args, def);
            }
        });
    } catch (Exception e) {
        return null;
    }
    return retValue[0];
}