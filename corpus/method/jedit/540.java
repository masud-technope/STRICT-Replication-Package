/**
	 * Parse an octal integer from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The integer value of the octal bytes.
	 */
public static int getOctalBytes(long value, byte[] buf, int offset, int length) {
    byte[] result = new byte[length];
    int idx = length - 1;
    buf[offset + idx] = 0;
    --idx;
    buf[offset + idx] = (byte) ' ';
    --idx;
    if (value == 0) {
        buf[offset + idx] = (byte) '0';
        --idx;
    } else {
        for (long val = value; idx >= 0 && val > 0; --idx) {
            buf[offset + idx] = (byte) ((byte) '0' + (byte) (val & 7));
            val = val >> 3;
        }
    }
    for (; idx >= 0; --idx) {
        buf[offset + idx] = (byte) ' ';
    }
    return offset + length;
}