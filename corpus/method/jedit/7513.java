//}}}
//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate msg) {
    Buffer buffer = msg.getBuffer();
    if (msg.getWhat() == BufferUpdate.DIRTY_CHANGED || msg.getWhat() == BufferUpdate.LOADED) {
        EditPane[] editPanes = getEditPanes();
        for (EditPane ep : editPanes) {
            if (ep.getBuffer() == buffer) {
                updateTitle();
                break;
            }
        }
    }
}