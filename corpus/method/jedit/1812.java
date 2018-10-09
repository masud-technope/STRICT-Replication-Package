/**
   * Returns the number of dimensions of this array type.
   * This method should only be used for an array type.
   *
   * @return the number of dimensions of this array type.
   */
public int getDimensions() {
    int i = 1;
    while (buf[off + i] == '[') {
        ++i;
    }
    return i;
}