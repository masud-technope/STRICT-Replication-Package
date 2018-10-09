/**
	 * Parse an entry name from a header buffer.
	 *
	 * @param header The header buffer from which to parse.
	 * @param offset The offset into the buffer from which to parse.
	 * @param length The number of header bytes to parse.
	 * @return The header's entry name.
	 */
public static StringBuffer parseName(byte[] header, int offset, int length) throws InvalidHeaderException {
    StringBuffer result = new StringBuffer(length);
    int end = offset + length;
    for (int i = offset; i < end; ++i) {
        if (header[i] == 0)
            break;
        result.append((char) header[i]);
    }
    return result;
}