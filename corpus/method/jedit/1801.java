/**
   * Returns the Java type corresponding to the given type descriptor.
   *
   * @param buf a buffer containing a type descriptor.
   * @param off the offset of this descriptor in the previous buffer.
   * @return the Java type corresponding to the given type descriptor.
   */
private static Type getType(final char[] buf, final int off) {
    int len;
    switch(buf[off]) {
        case 'V':
            return VOID_TYPE;
        case 'Z':
            return BOOLEAN_TYPE;
        case 'C':
            return CHAR_TYPE;
        case 'B':
            return BYTE_TYPE;
        case 'S':
            return SHORT_TYPE;
        case 'I':
            return INT_TYPE;
        case 'F':
            return FLOAT_TYPE;
        case 'J':
            return LONG_TYPE;
        case 'D':
            return DOUBLE_TYPE;
        case '[':
            len = 1;
            while (buf[off + len] == '[') {
                ++len;
            }
            if (buf[off + len] == 'L') {
                ++len;
                while (buf[off + len] != ';') {
                    ++len;
                }
            }
            return new Type(ARRAY, buf, off, len + 1);
        //case 'L':
        default:
            len = 1;
            while (buf[off + len] != ';') {
                ++len;
            }
            return new Type(OBJECT, buf, off, len + 1);
    }
}