//}}}
//{{{ getCellRenderer() method
@Override
public TableCellRenderer getCellRenderer(int row, int column) {
    if (column == 0) {
        Entry entry = ((CheckBoxListModel) getModel()).items.get(row);
        if (entry.caption)
            return dummy;
    }
    return super.getCellRenderer(row, column);
}