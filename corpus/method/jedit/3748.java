@Override
public void processMouseEvent(MouseEvent evt) {
    if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
        startIndex = list.locationToIndex(evt.getPoint());
    }
    super.processMouseEvent(evt);
}