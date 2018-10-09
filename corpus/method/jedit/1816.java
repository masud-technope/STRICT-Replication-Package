/**
   * Returns the descriptor corresponding to the given Java type.
   *
   * @param c an object class, a primitive class or an array class.
   * @return the descriptor corresponding to the given class.
   */
public static String getDescriptor(final Class c) {
    StringBuilder buf = new StringBuilder();
    getDescriptor(buf, c);
    return buf.toString();
}