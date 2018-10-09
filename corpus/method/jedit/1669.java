/**
        Get the bsh method matching the specified signature declared in
        this name space or a parent.
        <p>
        Note: this method is primarily intended for use internally.  If you use
        this method outside of the bsh package you will have to be familiar
        with BeanShell's use of the Primitive wrapper class.
        @see org.gjt.sp.jedit.bsh.Primitive
        @return the BshMethod or null if not found
        @param declaredOnly if true then only methods declared directly in this
            namespace will be found and no inherited or imported methods will
            be visible.
    */
public BshMethod getMethod(String name, Class[] sig, boolean declaredOnly) throws UtilEvalError {
    BshMethod method = null;
    // Get import first.
    if (method == null && isClass && !declaredOnly)
        method = getImportedMethod(name, sig);
    Object m = null;
    if (method == null && methods != null) {
        m = methods.get(name);
        // m contains either BshMethod or Vector of BshMethod
        if (m != null) {
            // unwrap
            BshMethod[] ma;
            if (m instanceof Vector) {
                Vector vm = (Vector) m;
                ma = new BshMethod[vm.size()];
                vm.copyInto(ma);
            } else
                ma = new BshMethod[] { (BshMethod) m };
            // Apply most specific signature matching
            Class[][] candidates = new Class[ma.length][];
            for (int i = 0; i < ma.length; i++) candidates[i] = ma[i].getParameterTypes();
            int match = Reflect.findMostSpecificSignature(sig, candidates);
            if (match != -1)
                method = ma[match];
        }
    }
    if (method == null && !isClass && !declaredOnly)
        method = getImportedMethod(name, sig);
    // try parent
    if (!declaredOnly && (method == null) && (parent != null))
        return parent.getMethod(name, sig);
    return method;
}