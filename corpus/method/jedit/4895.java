//}}}
//{{{ showPluginErrorDialog() method
private static void showPluginErrorDialog() {
    if (pluginErrors == null)
        return;
    String caption = getProperty("plugin-error.caption" + (pluginErrors.size() == 1 ? "-1" : ""));
    Frame frame = (PluginManager.getInstance() == null ? viewsFirst : PluginManager.getInstance());
    new ErrorListDialog(frame, getProperty("plugin-error.title"), caption, pluginErrors, true);
    pluginErrors = null;
}