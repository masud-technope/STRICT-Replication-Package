@Override
public void mouseClicked(MouseEvent evt) {
    int column = table.getTableHeader().columnAtPoint(evt.getPoint());
    pluginModel.sortDirection *= -1;
    pluginModel.sort(column);
}