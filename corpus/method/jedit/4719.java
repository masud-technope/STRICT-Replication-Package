//}}}
//{{{ error() method
/**
	 * Reports an I/O error with default urgency, <code>Log.ERROR</code>
	 *
	 * @param comp The component
	 * @param path The path name that caused the error
	 * @param messageProp The error message property name
	 * @param args Positional parameters
	 * @since jEdit 4.0pre3
	 */
public static void error(Component comp, final String path, String messageProp, Object[] args) {
    error(comp, path, messageProp, args, Log.ERROR);
}