//}}}
//{{{ handleVFSUpdate() method
@EBHandler
public void handleVFSUpdate(VFSUpdate msg) {
    maybeReloadDirectory(msg.getPath());
}