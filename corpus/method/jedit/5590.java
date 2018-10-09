//}}}
//{{{ deactivatePlugin() method
/**
	 * Unloads the plugin core class. Does nothing if the plugin core class
	 * has not been loaded.
	 * This method can only be called from the AWT event dispatch thread!
	 * @see EditPlugin#stop()
	 *
	 * @since jEdit 4.2pre3
	 */
public void deactivatePlugin(boolean exit) {
    if (!activated)
        return;
    if (!exit) {
        // buffers retain a reference to the fold handler in
        // question... and the easiest way to handle fold
        // handler unloading is this...
        Buffer buffer = jEdit.getFirstBuffer();
        while (buffer != null) {
            if (buffer.getFoldHandler().getClass().getClassLoader() == classLoader) {
                buffer.setFoldHandler(new DummyFoldHandler());
            }
            buffer = buffer.getNext();
        }
    }
    if (plugin != null && !(plugin instanceof EditPlugin.Broken)) {
        if (plugin instanceof EBPlugin || plugin.getClass().getAnnotation(EBHandler.class) != null) {
            EditBus.removeFromBus(plugin);
        }
        try {
            plugin.stop();
        } catch (Throwable t) {
            Log.log(Log.ERROR, this, "Error while " + "stopping plugin:");
            Log.log(Log.ERROR, this, t);
        }
        plugin = new EditPlugin.Deferred(this, plugin.getClassName());
        EditBus.send(new PluginUpdate(this, PluginUpdate.DEACTIVATED, exit));
        if (!exit) {
            // see if this is a 4.1-style plugin
            String activate = jEdit.getProperty("plugin." + plugin.getClassName() + ".activate");
            if (activate == null) {
                breakPlugin();
                jEdit.pluginError(path, "plugin-error.not-42", null);
            }
        }
    }
    activated = false;
}