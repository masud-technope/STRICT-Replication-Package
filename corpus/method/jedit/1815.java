// --------------------------------------------------------------------------
// Direct conversion from classes to type descriptors,
// without intermediate Type objects
// --------------------------------------------------------------------------
/**
   * Returns the internal name of the given class. The internal name of a class
   * is its fully qualified name, where '.' are replaced by '/'.
   *
   * @param c an object class.
   * @return the internal name of the given class.
   */
public static String getInternalName(final Class c) {
    return c.getName().replace('.', '/');
}