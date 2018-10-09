public Object getValueAt(int row, int col) {
    JCheckBoxList.Entry entry = items.get(row);
    switch(col) {
        case 0:
            return Boolean.valueOf(entry.checked);
        case 1:
            return entry.value;
        default:
            throw new InternalError();
    }
}