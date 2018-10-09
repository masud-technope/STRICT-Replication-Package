@Override
public void valueChanged(ListSelectionEvent e) {
    if (table.getSelectedRowCount() == 0)
        setEnabled(false);
    else
        setEnabled(true);
}