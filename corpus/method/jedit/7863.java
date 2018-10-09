// }}}
// {{{ createOptionTreeModel() 
public OptionTreeModel createOptionTreeModel() {
    OptionTreeModel paneTreeModel = new OptionTreeModel();
    OptionGroup rootGroup = (OptionGroup) paneTreeModel.getRoot();
    // initialize the Plugins branch of the options tree
    setSort(true);
    // Query plugins for option panes
    EditPlugin[] plugins = jEdit.getPlugins();
    for (EditPlugin ep : plugins) {
        if (ep instanceof EditPlugin.Broken)
            continue;
        String className = ep.getClassName();
        String optionPane = jEdit.getProperty("plugin." + className + ".option-pane");
        if (optionPane != null)
            addOptionPane(optionPane);
        else {
            String options = jEdit.getProperty("plugin." + className + ".option-group");
            if (options != null) {
                addOptionGroup(new OptionGroup("plugin." + className, jEdit.getProperty("plugin." + className + ".name"), options));
            }
        }
    }
    // only add the Plugins branch if there are OptionPanes
    if (getMemberCount() == 0)
        addOptionPane(new NoPluginsPane());
    rootGroup.addOptionGroup(this);
    return paneTreeModel;
}