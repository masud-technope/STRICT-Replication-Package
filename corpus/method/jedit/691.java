//}}}
//{{{ runCachedBlock() method
/**
	 * Runs a cached block of code in the specified namespace. Faster than
	 * evaluating the block each time.
	 * @param method The method instance returned by cacheBlock()
	 * @param param a parameter
	 * @param namespace The namespace to run the code in
	 * @return an object
	 * @exception Exception instances are thrown when various BeanShell
	 * errors occur
	 */
public Object runCachedBlock(BshMethod method, T param, NameSpace namespace) throws Exception {
    boolean useNamespace;
    if (namespace == null) {
        useNamespace = false;
        namespace = global;
    } else
        useNamespace = true;
    try {
        setupDefaultVariables(namespace, param);
        Object retVal = method.invoke(useNamespace ? new Object[] { namespace } : NO_ARGS, interpForMethods, new CallStack(), null);
        if (retVal instanceof Primitive) {
            if (retVal == Primitive.VOID)
                return null;
            else
                return ((Primitive) retVal).getValue();
        } else
            return retVal;
    } catch (Exception e) {
        return null;
    } finally {
        resetDefaultVariables(namespace);
    }
}