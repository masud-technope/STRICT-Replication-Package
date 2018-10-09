/**
		 * Implemented to pass the event to the original only if the
		 * mouseX doesn't lead to dragging the column over the first.
		 */
@Override
public void mouseDragged(MouseEvent e) {
    TableColumn dragged = header.getDraggedColumn();
    if (dragged != null) {
        int index = header.getTable().convertColumnIndexToView(dragged.getModelIndex());
        if (// dragged column is at second position...
        index == 1) {
            // allow only drags to the right
            if (e.getX() < minMouseX)
                return;
        }
    }
    mouseMotionDelegate.mouseDragged(e);
}