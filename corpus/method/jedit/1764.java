/**
   * Reads a signed short value in the given byte array.
   *
   * @param b a byte array.
   * @param index the start index of the value to be read.
   * @return the read value.
   */
static short readShort(final byte[] b, final int index) {
    return (short) (((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF));
}