//}}}
//{{{ selectAll() method
@Override
public void selectAll() {
    CheckBoxListModel model = (CheckBoxListModel) getModel();
    for (int i = 0; i < model.items.size(); i++) {
        Entry entry = model.items.elementAt(i);
        if (!entry.caption)
            entry.checked = true;
    }
    model.fireTableRowsUpdated(0, model.getRowCount());
}