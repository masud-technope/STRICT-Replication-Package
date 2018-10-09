//{{{ ClearPluginSet constructor
 ClearPluginSet() {
    setIcon(GUIUtilities.loadIcon(jEdit.getProperty("install-plugins.clear-plugin-set.icon")));
    setToolTipText("clear plugin set");
    addActionListener(this);
//}}}
}