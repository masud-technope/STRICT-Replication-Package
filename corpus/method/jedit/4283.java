//}}}
//{{{ input() method
/**
	 * Displays an input dialog box and returns any text the user entered.
	 * The title of the dialog is fetched from
	 * the <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param def The text to display by default in the input field
	 * @param args Positional parameters to be substituted into the
	 * message text
	 * @since jEdit 3.1pre3
	 */
public static String input(final Component comp, final String name, final Object[] args, final Object def) {
    if (EventQueue.isDispatchThread()) {
        hideSplashScreen();
        return (String) JOptionPane.showInputDialog(comp, jEdit.getProperty(name.concat(".message"), args), jEdit.getProperty(name.concat(".title")), JOptionPane.QUESTION_MESSAGE, null, null, def);
    }
    final String[] retValue = new String[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = input(comp, name, args, def);
            }
        });
    } catch (Exception e) {
        return null;
    }
    return retValue[0];
}