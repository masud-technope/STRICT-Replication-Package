//}}}
//{{{ confirm() method
/**
	 * Utility method that can be used to ask for confirmation in a macro.
	 * @param comp The component to show the dialog on behalf of, this
	 * will usually be a view instance
	 * @param prompt The prompt string
	 * @param buttons The buttons to display - for example,
	 * JOptionPane.YES_NO_CANCEL_OPTION
	 * @param type The dialog type - for example,
	 * JOptionPane.WARNING_MESSAGE
	 */
public static int confirm(final Component comp, final String prompt, final int buttons, final int type) {
    if (EventQueue.isDispatchThread()) {
        GUIUtilities.hideSplashScreen();
        return JOptionPane.showConfirmDialog(comp, prompt, jEdit.getProperty("macro-confirm.title"), buttons, type);
    }
    final int[] retValue = new int[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = confirm(comp, prompt, buttons, type);
            }
        });
    } catch (Exception e) {
        return JOptionPane.CANCEL_OPTION;
    }
    return retValue[0];
}