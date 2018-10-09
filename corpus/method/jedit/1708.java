/**
   * Visits a method of the class. This method <i>must</i> return a new
   * {@link CodeVisitor CodeVisitor} instance (or <tt>null</tt>) each time it
   * is called, i.e., it should not return a previously returned visitor.
   *
   * @param access the method's access flags (see {@link Constants}). This
   *      parameter also indicates if the method is synthetic and/or deprecated.
   * @param name the method's name.
   * @param desc the method's descriptor (see {@link Type Type}).
   * @param exceptions the internal names of the method's exception
   *      classes (see {@link Type#getInternalName getInternalName}). May be
   *      <tt>null</tt>.
   * @return an object to visit the byte code of the method, or <tt>null</tt> if
   *      this class visitor is not interested in visiting the code of this
   *      method.
   */
CodeVisitor visitMethod(int access, String name, String desc, String[] exceptions);