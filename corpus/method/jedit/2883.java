//}}}
//{{{ removeBuffer() methods
/**
	 * Remove a buffer from the EditPane's bufferSet.
	 *
	 * @param editPane the editPane It cannot be null
	 * @param buffer the buffer
	 */
public void removeBuffer(EditPane editPane, Buffer buffer) {
    switch(scope) {
        case editpane:
            BufferSet bufferSet = editPane.getBufferSet();
            removeBuffer(bufferSet, buffer);
            break;
        case view:
            EditPane[] editPanes = editPane.getView().getEditPanes();
            for (EditPane pane : editPanes) {
                removeBuffer(pane.getBufferSet(), buffer);
            }
            break;
        case global:
            jEdit._closeBuffer(null, buffer);
            break;
    }
}