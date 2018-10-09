//{{{ updateUI method
@Override
public void updateUI() {
    path = jEdit.getProperty(PluginManager.PROPERTY_PLUGINSET, "");
    if (path.length() < 1)
        setToolTipText("Click here to choose a predefined plugin set");
    else
        setToolTipText("Choose pluginset (" + path + ')');
    super.updateUI();
//}}}
}