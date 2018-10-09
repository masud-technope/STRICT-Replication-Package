//}}}
//{{{ setFileFilter() method
/**
	 * @since jEdit 4.2pre1
	 */
public void setFileFilter(String glob) {
    this.glob = glob;
    invalidateCachedList();
}