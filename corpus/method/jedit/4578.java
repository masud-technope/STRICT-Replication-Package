@Override
public VFS getVFS() {
    return VFSManager.getVFSForProtocol(FavoritesVFS.PROTOCOL);
}