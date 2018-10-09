//}}}
//{{{ runCachedBlock() method
/**
	 * Runs a cached block of code in the specified namespace. Faster than
	 * evaluating the block each time.
	 * @param method The method instance returned by cacheBlock()
	 * @param view The view
	 * @param namespace The namespace to run the code in
	 * @return an object
	 * @exception Exception instances are thrown when various BeanShell
	 * errors occur
	 * @since jEdit 4.1pre1
	 */
public static Object runCachedBlock(BshMethod method, View view, NameSpace namespace) throws Exception {
    return bsh.runCachedBlock(method, view, namespace);
}