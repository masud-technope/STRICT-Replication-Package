//}}}
//{{{ handleMessage() method
@Override
public void handleMessage(EBMessage message) {
    if (message.getSource() == PluginManager.getInstance()) {
        chooseButton.path = jEdit.getProperty(PluginManager.PROPERTY_PLUGINSET, "");
        if (chooseButton.path.length() > 0) {
            loadPluginSet(chooseButton.path);
            pluginModel.clearSelection();
            chooseButton.updateUI();
        }
    }
}