//}}}
//{{{ handleBufferUpdate() method
@EBHandler
public void handleBufferUpdate(BufferUpdate bu) {
    if (view.getBuffer().equals(bu.getBuffer()) && (bu.getWhat().equals(BufferUpdate.MARKERS_CHANGED) || bu.getWhat().equals(BufferUpdate.LOADED))) {
        refreshList();
    }
}