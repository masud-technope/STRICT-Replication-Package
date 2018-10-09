//}}}
//{{{ getProperties() method
/**
	 * Returns the properties object which contains all known
	 * jEdit properties. Note that as of jEdit 4.2pre10, this returns a
	 * new collection, not the existing properties instance.
	 * @since jEdit 3.1pre4
	 */
public static Properties getProperties() {
    return propMgr.getProperties();
}