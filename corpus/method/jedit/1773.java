/**
   * Initializes this CodeWriter to define the bytecode of the specified method.
   *
   * @param access the method's access flags (see {@link Constants}).
   * @param name the method's name.
   * @param desc the method's descriptor (see {@link Type Type}).
   * @param exceptions the internal names of the method's exceptions. May be
   *      <tt>null</tt>.
   */
protected void init(final int access, final String name, final String desc, final String[] exceptions) {
    this.access = access;
    this.name = cw.newUTF8(name);
    this.desc = cw.newUTF8(desc);
    if (exceptions != null && exceptions.length > 0) {
        exceptionCount = exceptions.length;
        this.exceptions = new int[exceptionCount];
        for (int i = 0; i < exceptionCount; ++i) {
            this.exceptions[i] = cw.newClass(exceptions[i]).index;
        }
    }
    if (computeMaxs) {
        // updates maxLocals
        int size = getArgumentsAndReturnSizes(desc) >> 2;
        if ((access & Constants.ACC_STATIC) != 0) {
            --size;
        }
        if (size > maxLocals) {
            maxLocals = size;
        }
    }
}