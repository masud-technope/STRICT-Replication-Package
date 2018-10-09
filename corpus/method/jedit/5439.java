//}}}
//{{{ createOptionTreeModel() method
protected OptionTreeModel createOptionTreeModel() {
    OptionTreeModel paneTreeModel = new OptionTreeModel();
    OptionGroup rootGroup = (OptionGroup) paneTreeModel.getRoot();
    // initialize the Plugins branch of the options tree
    pluginsGroup = new OptionGroup("plugins");
    pluginsGroup.setSort(true);
    // Query plugins for option panes
    EditPlugin[] plugins = jEdit.getPlugins();
    for (EditPlugin ep : plugins) {
        if (ep instanceof EditPlugin.Broken)
            continue;
        String className = ep.getClassName();
        if (jEdit.getProperty("plugin." + className + ".activate") != null) {
            String optionPane = jEdit.getProperty("plugin." + className + ".option-pane");
            if (optionPane != null)
                pluginsGroup.addOptionPane(optionPane);
            else {
                String options = jEdit.getProperty("plugin." + className + ".option-group");
                if (options != null) {
                    pluginsGroup.addOptionGroup(new OptionGroup("plugin." + className, jEdit.getProperty("plugin." + className + ".name"), options));
                }
            }
        }
    }
    // only add the Plugins branch if there are OptionPanes
    if (pluginsGroup.getMemberCount() == 0)
        pluginsGroup.addOptionPane(new NoPluginsPane());
    rootGroup.addOptionGroup(pluginsGroup);
    return paneTreeModel;
}