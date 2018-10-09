//{{{ handleMessage() method
@EBHandler
public void handleVFSUpdate(VFSUpdate vmsg) {
    maybeReload(vmsg.getPath());
}