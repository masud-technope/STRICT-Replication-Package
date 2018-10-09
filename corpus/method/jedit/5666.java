//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent e) {
    pluginSet.clear();
    pluginModel.clearSelection();
    jEdit.unsetProperty(PluginManager.PROPERTY_PLUGINSET);
    chooseButton.updateUI();
//}}}
}