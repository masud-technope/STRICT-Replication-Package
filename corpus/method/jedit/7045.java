//{{{ processMouseEvent() method
@Override
protected void processMouseEvent(MouseEvent e, JLayer<? extends JComponent> l) {
    if (e.getID() == MouseEvent.MOUSE_PRESSED) {
        requestFocus();
    }
//}}}
}