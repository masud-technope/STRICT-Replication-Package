//{{{ startPlugin() method
private void startPlugin() {
    try {
        plugin.start();
    } catch (Throwable t) {
        breakPlugin();
        Log.log(Log.ERROR, PluginJAR.this, "Error while starting plugin " + plugin.getClassName());
        Log.log(Log.ERROR, PluginJAR.this, t);
        String[] args = { t.toString() };
        jEdit.pluginError(path, "plugin-error.start-error", args);
    }
    if (plugin instanceof EBPlugin || plugin.getClass().getAnnotation(EBHandler.class) != null) {
        if (jEdit.getProperty("plugin." + plugin.getClassName() + ".activate") == null) {
            // old plugins expected jEdit 4.1-style
            // behavior, where a PropertiesChanged
            // was sent after plugins were started
            ((EBComponent) plugin).handleMessage(new PropertiesChanged(null));
        }
        EditBus.addToBus(plugin);
    }
    // buffers retain a reference to the fold handler in
    // question... and the easiest way to handle fold
    // handler loading is this...
    Buffer buffer = jEdit.getFirstBuffer();
    while (buffer != null) {
        FoldHandler handler = FoldHandler.getFoldHandler(buffer.getStringProperty("folding"));
        // == null before loaded
        if (handler != null && handler != buffer.getFoldHandler()) {
            buffer.setFoldHandler(handler);
        }
        buffer = buffer.getNext();
    }
}