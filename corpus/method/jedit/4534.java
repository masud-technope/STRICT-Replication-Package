//{{{ getRewindedStream()
/**
		 * Returns the stream which can be read the contents of
		 * the original stream.
		 * Some bytes ware read from original stream for auto
		 * detections. But they are rewinded at this method.
		 */
public BufferedInputStream getRewindedStream() throws IOException {
    markedStream.reset();
    return markedStream;
//}}}
}