//{{{ getTableCellRendererComponent
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Task task = (Task) value;
    if (column == 0) {
        if (task.getMaximum() == 0L) {
            progress.setIndeterminate(true);
        } else {
            progress.setIndeterminate(false);
            long max = task.getMaximum();
            long val = task.getValue();
            if (max > Integer.MAX_VALUE) {
                max >>= 10L;
                val >>= 10L;
            }
            progress.setMaximum((int) max);
            progress.setValue((int) val);
        }
        progress.setToolTipText(task.getLabel());
        progress.setString(task.getStatus());
        return progress;
    }
    button.setEnabled(task.isCancellable());
    return button;
//}}}
}