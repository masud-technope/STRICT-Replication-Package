//}}}
//{{{ cacheBlock() method
/**
	 * Caches a block of code, returning a handle that can be passed to
	 * runCachedBlock().
	 * @param id An identifier. If null, a unique identifier is generated
	 * @param code The code
	 * @param namespace If true, the namespace will be set
	 * @return a bsh method
	 * @exception Exception instances are thrown when various BeanShell errors
	 * occur
	 * @since jEdit 4.1pre1
	 */
public static BshMethod cacheBlock(String id, String code, boolean namespace) throws Exception {
    return bsh.cacheBlock(id, code, namespace);
}