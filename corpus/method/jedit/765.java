//}}}
//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate bmsg) {
    if (bmsg.getWhat() == BufferUpdate.CREATED || bmsg.getWhat() == BufferUpdate.CLOSED) {
        browserView.updateFileView();
    }
}