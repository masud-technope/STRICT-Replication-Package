@Override
public void mouseClicked(MouseEvent evt) {
    int row = keyTable.getSelectedRow();
    int col = keyTable.getSelectedColumn();
    if (col != 0 && row != -1) {
        GrabKeyDialog gkd = new GrabKeyDialog(GenericGUIUtilities.getParentDialog(ShortcutsOptionPane.this), filteredModel.getDelegated().getBindingAt(filteredModel.getTrueRow(row), col - 1), allBindings, null);
        if (gkd.isOK())
            filteredModel.setValueAt(gkd.getShortcut(), row, col);
    }
}