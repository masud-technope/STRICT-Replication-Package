//}}}
//{{{ getHandler() method
/**
	 * Returns the macro handler with the specified name, or null if
	 * there is no registered handler with that name.
	 * @since jEdit 4.0pre6
	 */
public static Handler getHandler(String name) {
    for (Handler handler : macroHandlers) {
        if (handler.getName().equals(name))
            return handler;
    }
    return null;
}