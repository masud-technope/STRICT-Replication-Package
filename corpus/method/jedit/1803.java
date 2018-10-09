/**
   * Returns the Java type corresponding to the return type of the given
   * method.
   *
   * @param method a method.
   * @return the Java type corresponding to the return type of the given
   *      method.
   */
public static Type getReturnType(final Method method) {
    return getType(method.getReturnType());
}