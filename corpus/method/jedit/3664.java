//}}}
//{{{ processMouseEvent() method
protected void processMouseEvent(MouseEvent evt) {
    if (!isEnabled())
        return;
    switch(evt.getID()) {
        case MouseEvent.MOUSE_PRESSED:
            Border border = getBorder();
            Insets insets = border.getBorderInsets(HistoryTextField.this);
            if (evt.getX() >= getWidth() - insets.right || GenericGUIUtilities.isPopupTrigger(evt)) {
                controller.showPopupMenu(evt.isShiftDown());
            } else
                super.processMouseEvent(evt);
            break;
        case MouseEvent.MOUSE_EXITED:
            setCursor(Cursor.getDefaultCursor());
            super.processMouseEvent(evt);
            break;
        default:
            super.processMouseEvent(evt);
            break;
    }
}