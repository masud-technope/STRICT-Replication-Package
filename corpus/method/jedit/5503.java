@Override
public void mouseClicked(MouseEvent evt) {
    int row = styleTable.rowAtPoint(evt.getPoint());
    if (row == -1)
        return;
    SyntaxStyle style;
    SyntaxStyle current = (SyntaxStyle) styleModel.getValueAt(row, 1);
    String token = (String) styleModel.getValueAt(row, 0);
    JDialog dialog = GenericGUIUtilities.getParentDialog(SyntaxHiliteOptionPane.this);
    if (dialog != null)
        style = new StyleEditor(dialog, current, token).getStyle();
    else {
        View view = GUIUtilities.getView(SyntaxHiliteOptionPane.this);
        style = new StyleEditor(view, current, token).getStyle();
    }
    if (style != null)
        styleModel.setValueAt(style, row, 1);
}