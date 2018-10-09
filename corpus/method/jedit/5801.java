//}}}
//{{{ handlePropertiesChanged() method
@EBHandler
public void handlePropertiesChanged(PropertiesChanged message) {
    if (pluginList != null && shouldUpdatePluginList()) {
        pluginList = null;
        updatePluginList();
    }
}