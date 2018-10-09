//}}}
//}}}
//{{{ Canned dialog boxes
//{{{ message() method
/**
	 * Displays a dialog box.
	 * The title of the dialog is fetched from
	 * the <code><i>name</i>.title</code> property. The message is fetched
	 * from the <code><i>name</i>.message</code> property. The message
	 * is formatted by the property manager with <code>args</code> as
	 * positional parameters.
	 * @param comp The component to display the dialog for
	 * @param name The name of the dialog
	 * @param args Positional parameters to be substituted into the
	 * message text
	 */
public static void message(final Component comp, final String name, final Object[] args) {
    if (EventQueue.isDispatchThread()) {
        hideSplashScreen();
        JOptionPane.showMessageDialog(comp, jEdit.getProperty(name.concat(".message"), args), jEdit.getProperty(name.concat(".title"), args), JOptionPane.INFORMATION_MESSAGE);
    } else {
        try {
            EventQueue.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    message(comp, name, args);
                }
            });
        } catch (Exception // NOPMD
        e) {
        }
    }
}