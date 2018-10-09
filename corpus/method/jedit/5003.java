//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate bmsg) {
    if (bmsg.getWhat() == BufferUpdate.CLOSED && bmsg.getBuffer() == buffer) {
        stopRecording(view);
    }
//}}}
}