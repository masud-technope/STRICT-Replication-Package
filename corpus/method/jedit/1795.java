/**
   * Returns the descriptor corresponding to the given method.
   *
   * @param m a {@link Method Method} object.
   * @return the descriptor of the given method.
   */
public static String getMethodDescriptor(final Method m) {
    Class[] parameters = m.getParameterTypes();
    StringBuilder buf = new StringBuilder();
    buf.append('(');
    for (int i = 0; i < parameters.length; ++i) {
        getDescriptor(buf, parameters[i]);
    }
    buf.append(')');
    getDescriptor(buf, m.getReturnType());
    return buf.toString();
}