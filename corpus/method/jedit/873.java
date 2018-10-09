/**
		 * Implemented to do some tweaks/bookkeeping before/after
		 * passing the event to the original
		 *
		 * - temporarily disallow reordering if hit on first column
		 * - calculate the max mouseX that's allowable in dragging to the left
		 *
		 */
@Override
public void mousePressed(MouseEvent e) {
    int index = header.columnAtPoint(e.getPoint());
    boolean reorderingAllowed = header.getReorderingAllowed();
    if (index == 0) {
        // temporarily disable re-ordering
        header.setReorderingAllowed(false);
    }
    mouseDelegate.mousePressed(e);
    if (index == 0) {
        // re-enable re-ordering
        header.setReorderingAllowed(reorderingAllowed);
    }
    // Calculate minimum X for a column (all except the first one) when dragging
    if (header.getDraggedColumn() != null) {
        int draggedColumnX = header.getHeaderRect(index).x;
        int firstColumnWidth = header.getColumnModel().getColumn(0).getWidth();
        minMouseX = firstColumnWidth + (e.getX() - draggedColumnX) - 1;
    }
}