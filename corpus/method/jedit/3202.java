//}}}
//{{{ getSelection() method
public String getSelection() {
    if (!isOK)
        return null;
    if (separator.isSelected())
        return "-";
    else if (action.isSelected()) {
        AbstractContextOptionPane.MenuItem selectedValue = (AbstractContextOptionPane.MenuItem) list.getSelectedValue();
        return selectedValue == null ? null : selectedValue.actionName;
    } else
        throw new InternalError();
}