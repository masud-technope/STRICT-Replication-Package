//}}}
//{{{ confirm() method
/**
	 * Displays a confirm dialog box and returns the button pushed by the
	 * user. The title of the dialog is fetched from the
	 * <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param args Positional parameters to be substituted into the
	 * message text
	 * @param buttons The buttons to display - for example,
	 * JOptionPane.YES_NO_CANCEL_OPTION
	 * @param type The dialog type - for example,
	 * JOptionPane.WARNING_MESSAGE
	 * @since jEdit 3.1pre3
	 */
public static int confirm(final Component comp, final String name, final Object[] args, final int buttons, final int type) {
    if (EventQueue.isDispatchThread()) {
        hideSplashScreen();
        return JOptionPane.showConfirmDialog(comp, jEdit.getProperty(name + ".message", args), jEdit.getProperty(name + ".title"), buttons, type);
    }
    final int[] retValue = new int[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = confirm(comp, name, args, buttons, type);
            }
        });
    } catch (Exception e) {
        return JOptionPane.CANCEL_OPTION;
    }
    return retValue[0];
}