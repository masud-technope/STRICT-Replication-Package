//}}}
//{{{ stop() method
/**
	 * jEdit calls this method when the plugin is being unloaded. This can
	 * be when the program is exiting, or at any other time.<p>
	 *
	 * If a plugin uses state information or other persistent data
	 * that should be stored in a special format, this would be a good place
	 * to write the data to storage.  If the plugin uses jEdit's properties
	 * API to hold settings, no special processing is needed for them on
	 * exit, since they will be saved automatically.<p>
	 *
	 * With plugins written for jEdit 4.1 and below, this method is only
	 * called when the program is exiting. However, this is not the case
	 * for plugins using the new API. For example, if your plugin adds
	 * tool bars to views, make sure you correctly handle the case where
	 * views are still open when the plugin is unloaded.<p>
	 *
	 * To avoid memory leaks, this method should ensure that no references
	 * to any objects created by this plugin remain in the heap. In the
	 * case of actions, dockable windows and services, jEdit ensures this
	 * automatically. For other objects, your plugin must clean up maually.
	 * <p>
	 *
	 * The default implementation of this method does nothing.
	 *
	 * @since jEdit 2.1pre1
	 */
//}}}
public void stop() {
}