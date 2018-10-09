//{{{ VFSFile constructor
public  VFSFile(String name, String path, String deletePath, int type, long length, boolean hidden) {
    this.name = name;
    this.path = path;
    this.deletePath = deletePath;
    this.symlinkPath = path;
    this.type = type;
    this.length = length;
    this.hidden = hidden;
    if (path != null) {
        // maintain backwards compatibility
        VFS vfs = VFSManager.getVFSForPath(path);
        canRead = ((vfs.getCapabilities() & VFS.READ_CAP) != 0);
        canWrite = ((vfs.getCapabilities() & VFS.WRITE_CAP) != 0);
    }
}