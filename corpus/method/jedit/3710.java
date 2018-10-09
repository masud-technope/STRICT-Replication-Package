//}}}
//{{{ getSelectedValue() method
public Object getSelectedValue() {
    int row = getSelectedRow();
    if (row == -1) {
        return null;
    } else {
        return getModel().getValueAt(row, 1);
    }
}