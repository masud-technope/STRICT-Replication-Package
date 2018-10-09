@Override
public void mouseClicked(MouseEvent evt) {
    ShortcutsModel shortcutsModel = filteredModel.getDelegated();
    switch(keyTable.getTableHeader().columnAtPoint(evt.getPoint())) {
        case 0:
            shortcutsModel.sort(0);
            break;
        case 1:
            shortcutsModel.sort(1);
            break;
        case 2:
            shortcutsModel.sort(2);
            break;
    }
    setFilter();
}