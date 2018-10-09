//}}}
//{{{ message() method
/**
	 * Utility method that can be used to display a message dialog in a macro.
	 * @param comp The component to show the dialog on behalf of, this
	 * will usually be a view instance
	 * @param message The message
	 * @since jEdit 2.7pre2
	 */
public static void message(final Component comp, final String message) {
    if (EventQueue.isDispatchThread()) {
        GUIUtilities.hideSplashScreen();
        JOptionPane.showMessageDialog(comp, message, jEdit.getProperty("macro-message.title"), JOptionPane.INFORMATION_MESSAGE);
    } else {
        try {
            EventQueue.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    message(comp, message);
                }
            });
        } catch (Exception // NOPMD
        e) {
        }
    }
}