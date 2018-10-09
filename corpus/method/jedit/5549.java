//}}}
//{{{ getSelection() method
public ToolBarOptionPane.Button getSelection() {
    if (!isOK)
        return null;
    if (separator.isSelected())
        return new ToolBarOptionPane.Button("-", null, null, "-");
    else {
        Icon icon;
        String iconName;
        if (builtin.isSelected()) {
            ToolBarOptionPane.IconListEntry selectedIcon = (ToolBarOptionPane.IconListEntry) builtinCombo.getSelectedItem();
            icon = selectedIcon.icon;
            iconName = selectedIcon.name;
        } else {
            icon = fileButton.getIcon();
            iconName = fileIcon;
            if (iconName == null)
                iconName = "Blank24.gif";
        }
        String label;
        String actionName;
        if (action.isSelected()) {
            ToolBarOptionPane.Button button = (ToolBarOptionPane.Button) list.getSelectedValue();
            label = button.label;
            actionName = button.actionName;
        } else
            throw new InternalError();
        return new ToolBarOptionPane.Button(actionName, iconName, icon, label);
    }
}