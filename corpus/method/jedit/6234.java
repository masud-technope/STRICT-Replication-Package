//}}}
//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate bmsg) {
    Buffer buffer = bmsg.getBuffer();
    Object what = bmsg.getWhat();
    if (what == BufferUpdate.LOADED)
        visitBuffers(new BufferLoadedVisitor(), buffer);
    else if (what == BufferUpdate.CLOSED)
        visitBuffers(new BufferClosedVisitor(), buffer);
}