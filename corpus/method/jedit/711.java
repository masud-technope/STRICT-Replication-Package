//{{{ mousePressed() method
@Override
public void mousePressed(MouseEvent evt) {
    Point p = evt.getPoint();
    if (evt.getSource() != table) {
        p.x -= table.getX();
        p.y -= table.getY();
    }
    int row = table.rowAtPoint(p);
    int column = table.columnAtPoint(p);
    if (column == 0 && row != -1) {
        VFSDirectoryEntryTableModel.Entry entry = (VFSDirectoryEntryTableModel.Entry) table.getModel().getValueAt(row, 0);
        if (FileCellRenderer.ExpansionToggleBorder.isExpansionToggle(entry.level, p.x)) {
            table.toggleExpanded(row);
            return;
        }
    }
    if (GenericGUIUtilities.isMiddleButton(evt.getModifiersEx())) {
        if (row == -1)
            return;
        else if (evt.isShiftDown())
            table.getSelectionModel().addSelectionInterval(row, row);
        else
            table.getSelectionModel().setSelectionInterval(row, row);
    } else if (GenericGUIUtilities.isPopupTrigger(evt)) {
        if (popup != null && popup.isVisible()) {
            popup.setVisible(false);
            popup = null;
            return;
        }
        if (row == -1)
            showFilePopup(null, table, evt.getPoint());
        else {
            if (!table.getSelectionModel().isSelectedIndex(row))
                table.getSelectionModel().setSelectionInterval(row, row);
            showFilePopup(getSelectedFiles(), table, evt.getPoint());
        }
    }
//}}}
}