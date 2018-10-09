/**
	 * Compute the checksum of a tar entry header.
	 *
	 * @param buf The tar entry's header buffer.
	 * @return The computed checksum.
	 */
public long computeCheckSum(byte[] buf) {
    long sum = 0;
    for (int i = 0; i < buf.length; ++i) {
        sum += 255 & buf[i];
    }
    return sum;
}