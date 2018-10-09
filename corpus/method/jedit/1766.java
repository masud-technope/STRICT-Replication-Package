/**
   * Writes a short value in the given byte array.
   *
   * @param b a byte array.
   * @param index where the first byte of the short value must be written.
   * @param s the value to be written in the given byte array.
   */
static void writeShort(final byte[] b, final int index, final int s) {
    b[index] = (byte) (s >>> 8);
    b[index + 1] = (byte) s;
}