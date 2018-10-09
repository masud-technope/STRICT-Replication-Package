/**
	 * Parse an octal string from a header buffer. This is used for the
	 * file permission mode value.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The long value of the octal string.
	 */
public static long parseOctal(byte[] header, int offset, int length) throws InvalidHeaderException {
    long result = 0;
    boolean stillPadding = true;
    int end = offset + length;
    for (int i = offset; i < end; ++i) {
        if (header[i] == 0)
            break;
        if (header[i] == (byte) ' ' || header[i] == '0') {
            if (stillPadding)
                continue;
            if (header[i] == (byte) ' ')
                break;
        }
        stillPadding = false;
        result = (result << 3) + (header[i] - '0');
    }
    return result;
}