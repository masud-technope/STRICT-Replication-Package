/**
   * Appends the descriptor corresponding to this Java type to the given string
   * buffer.
   *
   * @param buf the string buffer to which the descriptor must be appended.
   */
private void getDescriptor(final StringBuilder buf) {
    switch(sort) {
        case VOID:
            buf.append('V');
            return;
        case BOOLEAN:
            buf.append('Z');
            return;
        case CHAR:
            buf.append('C');
            return;
        case BYTE:
            buf.append('B');
            return;
        case SHORT:
            buf.append('S');
            return;
        case INT:
            buf.append('I');
            return;
        case FLOAT:
            buf.append('F');
            return;
        case LONG:
            buf.append('J');
            return;
        case DOUBLE:
            buf.append('D');
            return;
        //case OBJECT:
        default:
            buf.append(this.buf, off, len);
    }
}