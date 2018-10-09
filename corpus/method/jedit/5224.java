/**
	 * Creates a VFS update message.
	 * @param path The path in question
	 */
public  VFSUpdate(String path) {
    super(null);
    if (path == null)
        throw new NullPointerException("Path must be non-null");
    this.path = path;
}