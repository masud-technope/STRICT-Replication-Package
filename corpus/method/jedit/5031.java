//}}}
//{{{ unregisterHandler() method
/**
	 * Removes a macro handler from the handlers list
	 * @since jEdit 4.4.1
	 */
public static void unregisterHandler(Handler handler) {
    if (macroHandlers.remove(handler)) {
        Log.log(Log.DEBUG, Macros.class, "Unregistered " + handler.getName() + " macro handler");
    } else {
        Log.log(Log.ERROR, Macros.class, "Cannot unregister " + handler.getName() + " macro handler - it is not registered.");
    }
}