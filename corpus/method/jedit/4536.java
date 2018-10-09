//}}}
//{{{ getDetectedEncoding() method
/**
	 * Returns an auto detected encoding from content of markedStream.
	 * This method assumes that markedStream is wrapped by
	 * getMarkedStream() method.
	 */
public static String getDetectedEncoding(BufferedInputStream markedStream) throws IOException {
    List<EncodingDetector> detectors = getEncodingDetectors();
    for (EncodingDetector detector : detectors) {
        // FIXME: Here the method reset() can fail if the
        // previous detector read more than buffer size of
        // markedStream.
        markedStream.reset();
        // Wrap once more so that calling mark()
        // or reset() in detectEncoding() don't
        // alter the mark position of markedStream.
        String detected = detector.detectEncoding(new BufferedInputStream(markedStream));
        if (detected != null) {
            return detected;
        }
    }
    return null;
}