//{{{ getExtendedAttribute() method
/**
	 * Returns the value of an extended attribute. Note that this
	 * returns formatted strings (eg, "10 Mb" for a file size of
	 * 1048576 bytes). If you need access to the raw data, access
	 * fields and methods of this class.
	 * @param name The extended attribute name
	 * @since jEdit 4.2pre1
	 */
public String getExtendedAttribute(String name) {
    if (name.equals(VFS.EA_TYPE)) {
        switch(getType()) {
            case FILE:
                return jEdit.getProperty("vfs.browser.type.file");
            case DIRECTORY:
                return jEdit.getProperty("vfs.browser.type.directory");
            case FILESYSTEM:
                return jEdit.getProperty("vfs.browser.type.filesystem");
            default:
                throw new IllegalArgumentException();
        }
    } else if (name.equals(VFS.EA_STATUS)) {
        if (isReadable()) {
            if (isWriteable())
                return jEdit.getProperty("vfs.browser.status.rw");
            else
                return jEdit.getProperty("vfs.browser.status.ro");
        } else {
            if (isWriteable())
                return jEdit.getProperty("vfs.browser.status.append");
            else
                return jEdit.getProperty("vfs.browser.status.no");
        }
    } else if (name.equals(VFS.EA_SIZE)) {
        if (getType() != FILE)
            return null;
        else
            return StandardUtilities.formatFileSize(getLength());
    } else
        return null;
}