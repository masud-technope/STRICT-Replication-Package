//}}}
//{{{ indexDirectory() method
/**
	 * Indexes all HTML and text files in the specified directory.
	 * @param dir The directory
	 */
public void indexDirectory(String dir) throws Exception {
    String[] files = VFSManager.getFileVFS()._listDirectory(null, dir, "*.{html,txt}", true, null);
    for (String file : files) indexURL(file);
}