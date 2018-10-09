/**
     * Write an octal value into a byte array.
     *
     * @param value The value to write.
     * @param buf The byte array into which to write.
     * @param offset The offset into the buffer from which to write.
     * @param length The number of header bytes to write.
     * @return The number of bytes written to the buffer.
     */
public static int getOctalBytes(long value, byte[] buf, int offset, int length) {
    int i;
    String tmp = Long.toOctalString(value);
    int c = tmp.length();
    for (i = 0; i < length && i < c; i++) {
        buf[offset + i] = (byte) tmp.charAt(i);
    }
    while (i < length) {
        buf[offset + i] = (byte) ' ';
        i++;
    }
    return offset + length;
}