//}}}
//{{{ registerHandler() method
/**
	 * Adds a macro handler to the handlers list
	 * @since jEdit 4.0pre6
	 */
public static void registerHandler(Handler handler) {
    if (getHandler(handler.getName()) != null) {
        Log.log(Log.ERROR, Macros.class, "Cannot register more than one macro handler with the same name");
        return;
    }
    Log.log(Log.DEBUG, Macros.class, "Registered " + handler.getName() + " macro handler");
    macroHandlers.add(handler);
}