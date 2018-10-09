//}}}
//{{{ handleEditPaneUpdate() method
@EBHandler
public void handleEditPaneUpdate(EditPaneUpdate msg) {
    EditPane editPane = msg.getEditPane();
    if (editPane != null && editPane.getView() == this && msg.getWhat() == EditPaneUpdate.BUFFER_CHANGED && editPane.getBuffer().isLoaded()) {
        closeDuplicateBuffers(msg);
        status.updateCaretStatus();
        status.updateBufferStatus();
        status.updateMiscStatus();
    }
}