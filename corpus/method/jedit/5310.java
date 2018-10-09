public void mouseClicked(MouseEvent evt) {
    Point p = evt.getPoint();
    int row = colorsTable.rowAtPoint(p);
    int column = colorsTable.columnAtPoint(p);
    if (row == -1 || column != 1)
        return;
    ColorChooserDialog dialog = new ColorChooserDialog((Window) SwingUtilities.getRoot(BrowserColorsOptionPane.this), (Color) colorsModel.getValueAt(row, 1));
    Color color = dialog.getColor();
    if (color != null)
        colorsModel.setValueAt(color, row, 1);
}