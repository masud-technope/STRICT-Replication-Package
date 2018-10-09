//}}}
//{{{ getHandlers() method
/**
	 * Returns an array containing the list of registered macro handlers
	 * @since jEdit 4.0pre6
	 */
public static Handler[] getHandlers() {
    Handler[] handlers = new Handler[macroHandlers.size()];
    return macroHandlers.toArray(handlers);
}