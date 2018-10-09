@Override
public void processMouseMotionEvent(MouseEvent evt) {
    if (evt.getID() == MouseEvent.MOUSE_DRAGGED) {
        int row = list.locationToIndex(evt.getPoint());
        if (row != -1) {
            if (startIndex == -1) {
                list.setSelectionInterval(row, row);
                startIndex = row;
            } else
                list.setSelectionInterval(startIndex, row);
            list.ensureIndexIsVisible(row);
            evt.consume();
        }
    } else
        super.processMouseMotionEvent(evt);
}