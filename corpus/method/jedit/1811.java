/**
   * Returns the Java type corresponding to the given type descriptor.
   *
   * @param typeDescriptor a type descriptor.
   * @return the Java type corresponding to the given type descriptor.
   */
public static Type getType(final String typeDescriptor) {
    return getType(typeDescriptor.toCharArray(), 0);
}