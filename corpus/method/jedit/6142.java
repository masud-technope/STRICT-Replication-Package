//}}}
//{{{ setRecursive() method
/**
	 * @since jEdit 4.2pre1
	 */
public void setRecursive(boolean recurse) {
    this.recurse = recurse;
    invalidateCachedList();
}