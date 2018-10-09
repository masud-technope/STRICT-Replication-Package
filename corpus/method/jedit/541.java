/**
	 * Parse an octal long integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The long value of the octal bytes.
	 */
public static int getLongOctalBytes(long value, byte[] buf, int offset, int length) {
    byte[] temp = new byte[length + 1];
    TarHeader.getOctalBytes(value, temp, 0, length + 1);
    System.arraycopy(temp, 0, buf, offset, length);
    return offset + length;
}