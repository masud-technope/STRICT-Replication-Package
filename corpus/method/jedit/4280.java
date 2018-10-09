//}}}
//{{{ option() method
/**
	 * Displays an option dialog dialog box and returns the button pushed by the
	 * user. The title of the dialog is fetched from the
	 * <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param args Positional parameters to be substituted into the
	 * message text
	 * @param type The dialog type - for example,
	 * JOptionPane.WARNING_MESSAGE
	 * @param options the buttons
	 * @param initialValue the initial value
	 * @since jEdit 4.5pre1
	 */
public static int option(final Component comp, final String name, final Object[] args, final int type, final Object[] options, final Object initialValue) {
    if (EventQueue.isDispatchThread()) {
        hideSplashScreen();
        return JOptionPane.showOptionDialog(comp, jEdit.getProperty(name + ".message", args), jEdit.getProperty(name + ".title"), JOptionPane.DEFAULT_OPTION, type, null, options, initialValue);
    }
    final int[] retValue = new int[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = option(comp, name, args, type, options, initialValue);
            }
        });
    } catch (Exception e) {
        return 0;
    }
    return retValue[0];
}