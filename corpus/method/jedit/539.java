/**
	 * Determine the number of bytes in an entry name.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The number of bytes in a header's entry name.
	 */
public static int getNameBytes(StringBuffer name, byte[] buf, int offset, int length) {
    int i;
    for (i = 0; i < length && i < name.length(); ++i) {
        buf[offset + i] = (byte) name.charAt(i);
    }
    for (; i < length; ++i) {
        buf[offset + i] = 0;
    }
    return offset + length;
}