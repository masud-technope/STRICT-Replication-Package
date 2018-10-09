//}}}
//{{{ isBinary() methods
/**
	 * Check if an InputStream is binary.
	 * First this tries encoding auto detection. If an encoding is
	 * detected, the stream should be a text stream. Otherwise, this
	 * will check the first characters 100
	 * (jEdit property vfs.binaryCheck.length) in the system default
	 * encoding. If more than 1 (jEdit property vfs.binaryCheck.count)
	 * NUL(\u0000) was found, the stream is declared binary.
	 *
	 * This is not 100% because sometimes the autodetection could fail.
	 *
	 * This method will not close the stream. You have to do it yourself
	 *
	 * @param in the stream
	 * @return <code>true</code> if the stream was detected as binary
	 * @throws IOException IOException If an I/O error occurs
	 * @since jEdit 4.3pre10
	 */
public static boolean isBinary(InputStream in) throws IOException {
    AutoDetection.Result detection = new AutoDetection.Result(in);
    // If an encoding is detected, this is a text stream
    if (detection.getDetectedEncoding() != null) {
        return false;
    }
    // might be wrong. But enough for binary detection.
    try {
        return containsNullCharacter(new InputStreamReader(detection.getRewindedStream()));
    } catch (MalformedInputException mie) {
        return true;
    }
}