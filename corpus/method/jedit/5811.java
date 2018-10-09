//}}}
//{{{ disablePlugin()
private void disablePlugin(PluginJAR jar, String name) {
    Log.log(Log.ERROR, this, "Plugin: " + name + " is not supported on this version of jEdit! ");
    if (!jEdit.getBooleanProperty("plugin-manager.disable-obsolete", true))
        return;
    jEdit.removePluginJAR(jar, false);
    String jarName = MiscUtilities.getFileName(jar.getPath());
    // Stop it from getting loaded on startup:
    jEdit.setBooleanProperty("plugin-blacklist." + jarName, true);
    // show as 'Unsupported' in Manage Panel:
    jEdit.setBooleanProperty("plugin." + jarName + ".disabled", true);
    jEdit.propertiesChanged();
}