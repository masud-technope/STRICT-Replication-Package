/**
   * Visits information about an inner class. This inner class is not
   * necessarily a member of the class being visited.
   *
   * @param name the internal name of an inner class (see {@link
   *      Type#getInternalName getInternalName}).
   * @param outerName the internal name of the class to which the inner class
   *      belongs (see {@link Type#getInternalName getInternalName}). May be
   *      <tt>null</tt>.
   * @param innerName the (simple) name of the inner class inside its enclosing
   *      class. May be <tt>null</tt> for anonymous inner classes.
   * @param access the access flags of the inner class as originally declared
   *      in the enclosing class.
   */
void visitInnerClass(String name, String outerName, String innerName, int access);