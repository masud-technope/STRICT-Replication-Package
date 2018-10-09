//}}}
//{{{ handleEditPaneUpdate() method
@EBHandler
public void handleEditPaneUpdate(EditPaneUpdate message) {
    if (message.getWhat() == EditPaneUpdate.DESTROYED) {
        EditPane editPane = message.getEditPane();
        BufferSet bufferSet = editPane.getBufferSet();
        Buffer[] allBuffers = bufferSet.getAllBuffers();
        for (Buffer buffer : allBuffers) {
            _removeBuffer(bufferSet, buffer);
        }
    }
}