/**
   * Returns the Java types corresponding to the argument types of the given
   * method descriptor.
   *
   * @param methodDescriptor a method descriptor.
   * @return the Java types corresponding to the argument types of the given
   *      method descriptor.
   */
public static Type[] getArgumentTypes(final String methodDescriptor) {
    char[] buf = methodDescriptor.toCharArray();
    int off = 1;
    int size = 0;
    while (true) {
        char car = buf[off++];
        if (car == ')') {
            break;
        } else if (car == 'L') {
            while (buf[off++] != ';') {
            }
            ++size;
        } else if (car != '[') {
            ++size;
        }
    }
    Type[] args = new Type[size];
    off = 1;
    size = 0;
    while (buf[off] != ')') {
        args[size] = getType(buf, off);
        off += args[size].len;
        size += 1;
    }
    return args;
}