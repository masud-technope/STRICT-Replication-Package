/**
   * Reads a signed int value in the given byte array.
   *
   * @param b a byte array.
   * @param index the start index of the value to be read.
   * @return the read value.
   */
static int readInt(final byte[] b, final int index) {
    return ((b[index] & 0xFF) << 24) | ((b[index + 1] & 0xFF) << 16) | ((b[index + 2] & 0xFF) << 8) | (b[index + 3] & 0xFF);
}