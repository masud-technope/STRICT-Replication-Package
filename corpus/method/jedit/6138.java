//}}}
//{{{ setDirectory() method
/**
	 * @since jEdit 4.2pre1
	 */
public void setDirectory(String directory) {
    this.directory = directory;
    invalidateCachedList();
}