//{{{ update() method
public void update() {
    Buffer buffer = view.getBuffer();
    String path = buffer.getPath();
    VFS vfs = VFSManager.getVFSForPath(path);
    Object session = vfs.createVFSSession(path, view);
    try {
        VFSFile file = vfs._getFile(session, path, view);
        if (file == null) {
            lastModifiedLabel.setText("");
        } else {
            lastModifiedLabel.setText(file.getExtendedAttribute(VFS.EA_MODIFIED));
        }
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e);
    } finally {
        try {
            vfs._endVFSSession(session, view);
        } catch (IOException e) {
        }
    }
//}}}
}