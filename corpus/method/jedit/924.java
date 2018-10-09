 GetFileTypeRequest(VFS vfs, Object session, String path, int[] type) {
    super();
    this.vfs = vfs;
    this.session = session;
    this.path = path;
    this.type = type;
}