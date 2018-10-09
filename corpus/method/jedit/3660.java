//{{{ mouseMoved() method
public void mouseMoved(MouseEvent evt) {
    Border border = getBorder();
    Insets insets = border.getBorderInsets(HistoryTextField.this);
    if (evt.getX() >= getWidth() - insets.right)
        setCursor(Cursor.getDefaultCursor());
    else
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//}}}
}