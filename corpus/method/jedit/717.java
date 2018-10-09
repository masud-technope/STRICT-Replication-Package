//{{{ mouseClicked() method
@Override
public void mouseClicked(MouseEvent evt) {
    Point p = evt.getPoint();
    int row = table.rowAtPoint(p);
    int column = table.columnAtPoint(p);
    if (row == -1)
        return;
    if (column == 0) {
        VFSDirectoryEntryTableModel.Entry entry = (VFSDirectoryEntryTableModel.Entry) table.getModel().getValueAt(row, 0);
        if (FileCellRenderer.ExpansionToggleBorder.isExpansionToggle(entry.level, p.x)) {
            return;
        }
    }
    if ((evt.getModifiersEx() & BUTTON1_DOWN_MASK) == 0 && evt.getClickCount() % 2 == 0) {
        browser.filesActivated(evt.isShiftDown() ? VFSBrowser.M_OPEN_NEW_VIEW : VFSBrowser.M_OPEN, true);
    } else if (GenericGUIUtilities.isMiddleButton(evt.getModifiersEx())) {
        if (evt.isShiftDown())
            table.getSelectionModel().addSelectionInterval(row, row);
        else
            table.getSelectionModel().setSelectionInterval(row, row);
        browser.filesActivated(evt.isShiftDown() ? VFSBrowser.M_OPEN_NEW_VIEW : VFSBrowser.M_OPEN, true);
    }
//}}}
}