//}}}
//{{{ write() method
protected void write(Buffer buffer, OutputStream out) throws IOException, InterruptedException {
    String encodingName = buffer.getStringProperty(JEditBuffer.ENCODING);
    Encoding encoding = EncodingServer.getEncoding(encodingName);
    Writer writer = encoding.getTextWriter(new BufferedOutputStream(out, getByteIOBufferSize()));
    Segment lineSegment = new Segment();
    String newline = buffer.getStringProperty(JEditBuffer.LINESEP);
    if (newline == null)
        newline = System.getProperty("line.separator");
    final int bufferLineCount = buffer.getLineCount();
    setMaximum(bufferLineCount / PROGRESS_INTERVAL);
    setValue(0);
    int i = 0;
    while (i < bufferLineCount) {
        if (Thread.interrupted())
            throw new InterruptedException();
        buffer.getLineText(i, lineSegment);
        try {
            writer.write(lineSegment.array, lineSegment.offset, lineSegment.count);
            if (i < bufferLineCount - 1 || (jEdit.getBooleanProperty("stripTrailingEOL") && buffer.getBooleanProperty(Buffer.TRAILING_EOL))) {
                writer.write(newline);
            }
        } catch (CharacterCodingException e) {
            String message = getWriteEncodingErrorMessage(encodingName, encoding, lineSegment, i);
            IOException wrapping = new CharConversionException(message);
            wrapping.initCause(e);
            throw wrapping;
        }
        if (++i % PROGRESS_INTERVAL == 0)
            setValue(i / PROGRESS_INTERVAL);
    }
    writer.flush();
}