//}}}
//{{{ cacheBlock() method
/**
	 * Caches a block of code, returning a handle that can be passed to
	 * runCachedBlock().
	 * @param id An identifier.
	 * @param code The code
	 * @param namespace If true, the namespace will be set
	 * @return a hsh method
	 * @exception Exception instances are thrown when various BeanShell errors
	 * occur
	 */
public BshMethod cacheBlock(String id, String code, boolean namespace) throws Exception {
    // Make local namespace so that the method could be GCed
    // if it becomes unnecessary.
    NameSpace local = new NameSpace(global, "__internal_" + id);
    // This name should be unique enough not to shadow any outer
    // identifier.
    String name = "__runCachedMethod";
    if (namespace) {
        _eval(null, local, name + "(ns) {\nthis.callstack.set(0,ns);\n" + code + "\n}");
        return local.getMethod(name, new Class[] { NameSpace.class });
    } else {
        _eval(null, local, name + "() {\n" + code + "\n}");
        return local.getMethod(name, new Class[0]);
    }
}