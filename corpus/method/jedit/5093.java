//}}}
//{{{ autodetect() method
/**
	 * Tries to detect if the stream is gzipped, and if it has an encoding
	 * specified with an XML PI.
	 *
	 * @param in the input stream reader that must be autodetected
	 * @param buffer a buffer. It can be null if you only want to autodetect the encoding of a file
	 * @return a Reader using the detected encoding
	 * @throws IOException io exception during read
	 * @since jEdit 4.3pre5
	 */
public static Reader autodetect(InputStream in, Buffer buffer) throws IOException {
    String encoding;
    if (buffer == null)
        encoding = System.getProperty("file.encoding");
    else
        encoding = buffer.getStringProperty(JEditBuffer.ENCODING);
    boolean gzipped = false;
    if (buffer == null || buffer.getBooleanProperty(Buffer.ENCODING_AUTODETECT)) {
        AutoDetection.Result detection = new AutoDetection.Result(in);
        gzipped = detection.streamIsGzipped();
        if (gzipped) {
            Log.log(Log.DEBUG, MiscUtilities.class, "Stream is Gzipped");
        }
        String detected = detection.getDetectedEncoding();
        if (detected != null) {
            encoding = detected;
            Log.log(Log.DEBUG, MiscUtilities.class, "Stream encoding detected is " + detected);
        }
        in = detection.getRewindedStream();
    } else {
        // Make the stream buffered in the same way.
        in = AutoDetection.getMarkedStream(in);
    }
    Reader result = EncodingServer.getTextReader(in, encoding);
    if (buffer != null) {
        // Store the successful properties.
        if (gzipped) {
            buffer.setBooleanProperty(Buffer.GZIPPED, true);
        }
        buffer.setProperty(JEditBuffer.ENCODING, encoding);
    }
    return result;
}