//}}}
//{{{ input() method
/**
	 * Utility method that can be used to prompt for input in a macro.
	 * @param comp The component to show the dialog on behalf of, this
	 * will usually be a view instance
	 * @param prompt The prompt string
	 * @since jEdit 2.7pre2
	 */
public static String input(Component comp, String prompt) {
    GUIUtilities.hideSplashScreen();
    return input(comp, prompt, null);
}