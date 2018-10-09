/**
	 * Add a buffer into the given editPane.
	 * If the editPane is null, it will be added to the current
	 * editPane of the active view.
	 * @param editPane an EditPane (or null)
	 * @param buffer the buffer to add
	 */
public void addBuffer(EditPane editPane, final Buffer buffer) {
    if (editPane == null) {
        editPane = jEdit.getActiveView().getEditPane();
    }
    BufferSet bufferSet = editPane.getBufferSet();
    switch(scope) {
        case editpane:
            bufferSet.addBuffer(buffer);
            break;
        case view:
            EditPane[] editPanes = editPane.getView().getEditPanes();
            for (EditPane pane : editPanes) {
                if (pane == null)
                    continue;
                BufferSet bfs = pane.getBufferSet();
                bfs.addBuffer(buffer);
            }
            break;
        case global:
            jEdit.visit(new JEditVisitorAdapter() {

                @Override
                public void visit(EditPane editPane) {
                    BufferSet bfs = editPane.getBufferSet();
                    bfs.addBuffer(buffer);
                }
            });
    }
}