//}}}
//{{{ updateList() method
private void updateList() {
    ActionSet actionSet = (ActionSet) combo.getSelectedItem();
    String actionSetLabel = actionSet.getLabel();
    jEdit.setProperty("options.toolbar.selectedActionSet", actionSetLabel);
    EditAction[] actions = actionSet.getActions();
    Vector<ToolBarOptionPane.Button> listModel = new Vector<ToolBarOptionPane.Button>(actions.length);
    for (EditAction action : actions) {
        String label = action.getLabel();
        if (label == null)
            continue;
        listModel.add(new ToolBarOptionPane.Button(action.getName(), null, null, label));
    }
    Collections.sort(listModel, new ToolBarOptionPane.ButtonCompare());
    list.setListData(listModel);
}