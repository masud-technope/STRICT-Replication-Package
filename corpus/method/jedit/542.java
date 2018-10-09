/**
	 * Parse the checksum octal integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The integer value of the entry's checksum.
	 */
public static int getCheckSumOctalBytes(long value, byte[] buf, int offset, int length) {
    TarHeader.getOctalBytes(value, buf, offset, length);
    buf[offset + length - 1] = (byte) ' ';
    buf[offset + length - 2] = 0;
    return offset + length;
}