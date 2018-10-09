/**
   * Reads an unsigned short value in the given byte array.
   *
   * @param b a byte array.
   * @param index the start index of the value to be read.
   * @return the read value.
   */
static int readUnsignedShort(final byte[] b, final int index) {
    return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
}