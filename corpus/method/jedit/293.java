/**
     * Write a name into a byte array.
     *
     * @param name The name to write.
     * @param buf The byte array into which to write.
     * @param offset The offset into the buffer from which to write.
     * @param length The number of header bytes to write.
     * @return The number of bytes written to the buffer.
     */
public static int getNameBytes(StringBuffer name, byte[] buf, int offset, int length) {
    int i;
    int c = name.length();
    for (i = 0; i < length && i < c; i++) {
        buf[offset + i] = (byte) name.charAt(i);
    }
    while (i < length) {
        buf[offset + i] = (byte) ' ';
        i++;
    }
    return offset + length;
}