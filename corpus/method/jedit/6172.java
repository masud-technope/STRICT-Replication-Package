@EBHandler
public void handleBufferUpdate(BufferUpdate msg) {
    if (msg.getWhat() == BufferUpdate.LOADED && msg.getBuffer() == buffer) {
        bufferLoaded();
    }
}