//}}}
//{{{ input() method
/**
	 * Utility method that can be used to prompt for input in a macro.
	 * @param comp The component to show the dialog on behalf of, this
	 * will usually be a view instance
	 * @param prompt The prompt string
	 * @since jEdit 3.1final
	 */
public static String input(final Component comp, final String prompt, final String defaultValue) {
    if (EventQueue.isDispatchThread()) {
        GUIUtilities.hideSplashScreen();
        return (String) JOptionPane.showInputDialog(comp, prompt, jEdit.getProperty("macro-input.title"), JOptionPane.QUESTION_MESSAGE, null, null, defaultValue);
    }
    final String[] retValue = new String[1];
    try {
        EventQueue.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                retValue[0] = input(comp, prompt, defaultValue);
            }
        });
    } catch (Exception e) {
        return null;
    }
    return retValue[0];
}