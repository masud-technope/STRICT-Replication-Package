//}}}
//{{{ activatePlugin() method
/**
	 * Loads the plugin core class. Does nothing if the plugin core class
	 * has already been loaded. This method might be called on startup,
	 * depending on what properties are set. See {@link EditPlugin#start()}.
	 * This method is thread-safe.
	 *
	 * @since jEdit 4.2pre1
	 */
@SuppressWarnings("unchecked")
public void activatePlugin() {
    synchronized (this) {
        if (activated) {
            // recursive call
            return;
        }
        activated = true;
    }
    if (!(plugin instanceof EditPlugin.Deferred)) {
        return;
    }
    String className = plugin.getClassName();
    try {
        Class clazz = classLoader.loadClass(className, false);
        int modifiers = clazz.getModifiers();
        if (Modifier.isInterface(modifiers) || Modifier.isAbstract(modifiers) || !EditPlugin.class.isAssignableFrom(clazz)) {
            Log.log(Log.ERROR, this, "Plugin has properties but does not extend EditPlugin: " + className);
            breakPlugin();
            return;
        }
        plugin = (EditPlugin) clazz.getDeclaredConstructor().newInstance();
        plugin.jar = this;
    } catch (Throwable t) {
        breakPlugin();
        Log.log(Log.ERROR, this, "Error while starting plugin " + className);
        Log.log(Log.ERROR, this, t);
        String[] args = { t.toString() };
        jEdit.pluginError(path, "plugin-error.start-error", args);
        return;
    }
    if (jEdit.isMainThread() || SwingUtilities.isEventDispatchThread()) {
        startPlugin();
    } else {
        // for thread safety
        startPluginLater();
    }
    EditBus.sendAsync(new PluginUpdate(this, PluginUpdate.ACTIVATED, false));
}