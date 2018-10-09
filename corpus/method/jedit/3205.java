//{{{ updateList() method
private void updateList() {
    ActionSet actionSet = (ActionSet) combo.getSelectedItem();
    jEdit.setProperty(CONTEXT_ADD_DIALOG_LAST_SELECTION, actionSet.getLabel());
    EditAction[] actions = actionSet.getActions();
    // NOPMD
    Vector<MenuItem> listModel = new Vector<MenuItem>(actions.length);
    for (EditAction action : actions) {
        String label = action.getLabel();
        if (label == null)
            continue;
        listModel.addElement(new MenuItem(action.getName(), label));
    }
    Collections.sort(listModel, new AbstractContextOptionPane.MenuItemCompare());
    list.setListData(listModel);
}