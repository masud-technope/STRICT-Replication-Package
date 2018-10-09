/**
   * Returns the Java type corresponding to the return type of the given
   * method descriptor.
   *
   * @param methodDescriptor a method descriptor.
   * @return the Java type corresponding to the return type of the given
   *      method descriptor.
   */
public static Type getReturnType(final String methodDescriptor) {
    char[] buf = methodDescriptor.toCharArray();
    return getType(buf, methodDescriptor.indexOf(')') + 1);
}