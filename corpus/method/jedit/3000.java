//{{{ start() method
/**
	 * jEdit calls this method when the plugin is being activated, either
	 * during startup or at any other time. A plugin can get activated for
	 * a number of reasons:
	 *
	 * <ul>
	 * <li>The plugin is written for jEdit 4.1 or older, in which case it
	 * will always be loaded at startup.</li>
	 * <li>The plugin has its <code>activate</code> property set to
	 * <code>startup</code>, in which case it will always be loaded at
	 * startup.</li>
	 * <li>One of the properties listed in the plugin's
	 * <code>activate</code> property is set to <code>true</code>,
	 * in which case it will always be loaded at startup.</li>
	 * <li>One of the plugin's classes is being accessed by another plugin,
	 * a macro, or a BeanShell snippet in a plugin API XML file.</li>
	 * </ul>
	 *
	 * Note that this method is always called from the event dispatch
	 * thread, even if the activation resulted from a class being loaded
	 * from another thread. A side effect of this is that some of your
	 * plugin's code might get executed before this method finishes
	 * running.<p>
	 *
	 * When this method is being called for plugins written for jEdit 4.1
	 * and below, no views or buffers are open. However, this is not the
	 * case for plugins using the new API. For example, if your plugin adds
	 * tool bars to views, make sure you correctly handle the case where
	 * views are already open when the plugin is loaded.<p>
	 *
	 * If your plugin must be loaded on startup, take care to have this
	 * method return as quickly as possible.<p>
	 *
	 * The default implementation of this method does nothing.
	 *
	 * @since jEdit 2.1pre1
	 */
public void start() {
}