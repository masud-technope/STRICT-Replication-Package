//}}}
//{{{ getIconForFile() method
/**
	 * @since jEdit 4.3pre2
	 */
public static Icon getIconForFile(VFSFile file, boolean expanded) {
    return getIconForFile(file, expanded, jEdit._getBuffer(file.getSymlinkPath()) != null);
}