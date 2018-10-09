//}}}
//{{{ createOptionTreeModel() method
@Override
@SuppressWarnings("deprecation")
protected OptionTreeModel createOptionTreeModel() {
    OptionTreeModel paneTreeModel = new OptionTreeModel();
    OptionGroup rootGroup = (OptionGroup) paneTreeModel.getRoot();
    String optionGroups = jEdit.getProperty("options.groups");
    String[] groups = optionGroups.split(" ");
    for (String group : groups) {
        OptionGroup optionGroup = new OptionGroup(group);
        String optionPanes = jEdit.getProperty("options.group." + group);
        String[] panes = optionPanes.split(" ");
        for (String pane : panes) {
            optionGroup.addOptionPane(pane);
        }
        rootGroup.addOptionGroup(optionGroup);
    }
    return paneTreeModel;
}