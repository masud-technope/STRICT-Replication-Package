/**
   * Returns the descriptor corresponding to the given argument and return
   * types.
   *
   * @param returnType the return type of the method.
   * @param argumentTypes the argument types of the method.
   * @return the descriptor corresponding to the given argument and return
   *      types.
   */
public static String getMethodDescriptor(final Type returnType, final Type[] argumentTypes) {
    StringBuilder buf = new StringBuilder();
    buf.append('(');
    for (int i = 0; i < argumentTypes.length; ++i) {
        argumentTypes[i].getDescriptor(buf);
    }
    buf.append(')');
    returnType.getDescriptor(buf);
    return buf.toString();
}