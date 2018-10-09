/**
   * Visits the header of the class.
   *
   * @param access the class's access flags (see {@link Constants}). This
   *      parameter also indicates if the class is deprecated.
   * @param name the internal name of the class (see {@link Type#getInternalName
   *      getInternalName}).
   * @param superName the internal of name of the super class (see {@link
   *      Type#getInternalName getInternalName}). For interfaces, the super
   *      class is {@link Object}. May be <tt>null</tt>, but only for the {@link
   *      Object java.lang.Object} class.
   * @param interfaces the internal names of the class's interfaces (see {@link
   *      Type#getInternalName getInternalName}). May be <tt>null</tt>.
   * @param sourceFile the name of the source file from which this class was
   *      compiled. May be <tt>null</tt>.
   */
void visit(int access, String name, String superName, String[] interfaces, String sourceFile);