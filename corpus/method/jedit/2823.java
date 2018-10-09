//}}}
//{{{ read() method
protected SegmentBuffer read(Reader in, long length, boolean insert) throws IOException, InterruptedException {
    /* we guess an initial size for the array */
    IntegerArray endOffsets = new IntegerArray(Math.max(1, (int) (length / 50)));
    // only true if the file size is known
    boolean trackProgress = !buffer.isTemporary() && length != 0;
    if (trackProgress) {
        setMaximum(length);
        setValue(0);
    }
    // default buffer size
    if (length == 0)
        length = IOBUFSIZE;
    SegmentBuffer seg = new SegmentBuffer((int) length + 1);
    char[] buf = new char[IOBUFSIZE];
    /* Number of characters in 'buf' array.
		 InputStream.read() doesn't always fill the
		 array (eg, the file size is not a multiple of
		 IOBUFSIZE, or it is a GZipped file, etc) */
    int len;
    // True if a \n was read after a \r. Usually
    // means this is a DOS/Windows file
    boolean CRLF = false;
    // A \r was read, hence a MacOS file
    boolean CROnly = false;
    // Was the previous read character a \r?
    // If we read a \n and this is true, we assume
    // we have a DOS/Windows file
    boolean lastWasCR = false;
    // Number of lines read. Every 100 lines, we update the
    // progress bar
    int lineCount = 0;
    while ((len = in.read(buf, 0, buf.length)) != -1) {
        if (Thread.interrupted())
            throw new InterruptedException();
        // Offset of previous line, relative to
        // the start of the I/O buffer (NOT
        // relative to the start of the document)
        int lastLine = 0;
        for (int i = 0; i < len; i++) {
            // Look for line endings.
            switch(buf[i]) {
                case '\r':
                    // (\r\r in stream)
                    if (lastWasCR) {
                        CROnly = true;
                        CRLF = false;
                    } else // Otherwise set a flag,
                    // so that \n knows that last
                    // was a \r
                    {
                        lastWasCR = true;
                    }
                    // Insert a line
                    seg.append(buf, lastLine, i - lastLine);
                    seg.append('\n');
                    endOffsets.add(seg.count);
                    if (trackProgress && lineCount++ % PROGRESS_INTERVAL == 0)
                        setValue(seg.count);
                    // This is i+1 to take the
                    // trailing \n into account
                    lastLine = i + 1;
                    break;
                case '\n':
                    /* If lastWasCR is true, we just read a \r followed
					 by a \n. We specify that this is a Windows file,
					 but take no further action and just ignore the \r. */
                    if (lastWasCR) {
                        CROnly = false;
                        CRLF = true;
                        lastWasCR = false;
                        /* Bump lastLine so that the next line doesn't erronously
						  pick up the \r */
                        lastLine = i + 1;
                    } else /* Otherwise, we found a \n that follows some other
					 *  character, hence we have a Unix file */
                    {
                        CROnly = false;
                        CRLF = false;
                        seg.append(buf, lastLine, i - lastLine);
                        seg.append('\n');
                        endOffsets.add(seg.count);
                        if (trackProgress && lineCount++ % PROGRESS_INTERVAL == 0)
                            setValue(seg.count);
                        lastLine = i + 1;
                    }
                    break;
                default:
                    /*  If we find some other character that follows
					 a \r, so it is not a Windows file, and probably
					 a Mac file */
                    if (lastWasCR) {
                        CROnly = true;
                        CRLF = false;
                        lastWasCR = false;
                    }
                    break;
            }
        }
        if (trackProgress)
            setValue(seg.count);
        // Add remaining stuff from buffer
        seg.append(buf, lastLine, len - lastLine);
    }
    setCancellable(false);
    String lineSeparator;
    if (seg.count == 0) {
        // fix for "[ 865589 ] 0-byte files should open using
        // the default line seperator"
        lineSeparator = jEdit.getProperty("buffer.lineSeparator", System.getProperty("line.separator"));
    } else if (CRLF)
        lineSeparator = "\r\n";
    else if (CROnly)
        lineSeparator = "\r";
    else
        lineSeparator = "\n";
    // Chop trailing newline and/or ^Z (if any)
    int bufferLength = seg.count;
    if (bufferLength != 0) {
        char ch = seg.array[bufferLength - 1];
        if (/* DOS ^Z */
        ch == 0x1a)
            seg.count--;
    }
    buffer.setBooleanProperty(Buffer.TRAILING_EOL, false);
    if (bufferLength != 0 && jEdit.getBooleanProperty("stripTrailingEOL")) {
        char ch = seg.array[bufferLength - 1];
        if (ch == '\n') {
            buffer.setBooleanProperty(Buffer.TRAILING_EOL, true);
            seg.count--;
            endOffsets.setSize(endOffsets.getSize() - 1);
        }
    }
    // add a line marker at the end for proper offset manager
    // operation
    endOffsets.add(seg.count + 1);
    // post-load cleanup runnable, which runs in the AWT thread.
    if (!insert) {
        buffer.setProperty(LOAD_DATA, seg);
        buffer.setProperty(END_OFFSETS, endOffsets);
        buffer.setProperty(NEW_PATH, path);
        if (lineSeparator != null)
            buffer.setProperty(JEditBuffer.LINESEP, lineSeparator);
    }
    // used in insert()
    return seg;
}