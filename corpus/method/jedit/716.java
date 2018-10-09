@Override
public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
        case KeyEvent.VK_CONTEXT_MENU:
            if (popup != null && popup.isVisible()) {
                popup.setVisible(false);
                popup = null;
                return;
            }
            int row = table.getSelectedRow();
            Point pos = new Point(0, row * table.getRowHeight());
            if (row == -1)
                showFilePopup(null, table, pos);
            else {
                if (!table.getSelectionModel().isSelectedIndex(row))
                    table.getSelectionModel().setSelectionInterval(row, row);
                showFilePopup(getSelectedFiles(), table, pos);
            }
            break;
    }
}