//}}}
//{{{ getOwner() method
/**
	 * Return the editpane that owns the BufferSet
	 * @param bufferSet the bufferSet
	 * @return the owner of the given bufferSet
	 */
private static EditPane getOwner(BufferSet bufferSet) {
    View[] views = jEdit.getViews();
    for (View view : views) {
        EditPane[] editPanes = view.getEditPanes();
        for (EditPane editPane : editPanes) {
            if (editPane.getBufferSet() == bufferSet) {
                return editPane;
            }
        }
    }
    return null;
}