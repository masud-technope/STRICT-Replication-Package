/**
		 * Do some auto detection for a stream and hold the
		 * result in this instance.
		 * @param in the stream
		 */
public  Result(InputStream in) throws IOException {
    BufferedInputStream marked = getMarkedStream(in);
    gzipped = isGzipped(marked);
    if (gzipped) {
        marked.reset();
        marked = getMarkedStream(new GZIPInputStream(marked));
    }
    marked.reset();
    encoding = AutoDetection.getDetectedEncoding(marked);
    markedStream = marked;
//}}}
}