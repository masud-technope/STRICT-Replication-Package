//}}}
//{{{ setLogWriter() method
/**
	 * Writes all currently logged messages to this stream if there was no
	 * stream set previously, and sets the stream to write future log
	 * messages to.
	 * @param stream The writer
	 * @since jEdit 3.2pre4
	 */
public static void setLogWriter(Writer stream) {
    if (Log.stream == null && stream != null) {
        try {
            if (wrap) {
                for (int i = logLineCount; i < log.length; i++) {
                    stream.write(log[i]);
                    stream.write(lineSep);
                }
            }
            for (int i = 0; i < logLineCount; i++) {
                stream.write(log[i]);
                stream.write(lineSep);
            }
            stream.flush();
        } catch (Exception // NOPMD
        e) {
        }
    }
    Log.stream = stream;
}