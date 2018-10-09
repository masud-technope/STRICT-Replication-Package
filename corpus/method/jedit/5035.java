//}}}
//{{{ getHandlerForFileName() method
/**
	 * Returns the macro handler suitable for running the specified file
	 * name, or null if there is no suitable handler.
	 * @since jEdit 4.1pre3
	 */
public static Handler getHandlerForPathName(String pathName) {
    for (Handler handler : macroHandlers) {
        if (handler.accept(pathName))
            return handler;
    }
    return null;
}