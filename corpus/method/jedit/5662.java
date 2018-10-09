//{{{ ChoosePluginSet constructor
 ChoosePluginSet() {
    setIcon(GUIUtilities.loadIcon(jEdit.getProperty("install-plugins.choose-plugin-set.icon")));
    addActionListener(this);
    updateUI();
//}}}
}