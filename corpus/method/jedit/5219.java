/**
	 * @param source the View that is considered the "source" of this event
	 * @param isDirectory true if the path is pointing to a folder, false if it's a regular file
	 * @param path The selected path.
	 */
public  VFSPathSelected(View source, String path, boolean isDirectory) {
    super(source);
    this.path = path;
    this.isDir = isDirectory;
}