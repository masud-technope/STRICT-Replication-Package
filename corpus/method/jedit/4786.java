/**
	 * Creates a new `untitled' file.
	 *
	 * @param editPane The editPane to create the file in
	 * @param dir The directory to create the file in
	 *
	 * @return the new buffer
	 *
	 * @since jEdit 4.3pre17
	 */
public static Buffer newFile(EditPane editPane, String dir) {
    if (editPane != null) {
        BufferSet bufferSet = editPane.getBufferSet();
        Buffer[] buffers = bufferSet.getAllBuffers();
        for (Buffer buf : buffers) {
            if (buf.isUntitled() && !buf.isDirty()) {
                if (!MiscUtilities.getParentOfPath(buf.getPath()).equals(dir)) {
                    // Find the highest Untitled-n file
                    int untitledCount = getNextUntitledBufferId();
                    Buffer newBuffer = openFile(editPane, dir, "Untitled-" + untitledCount, true, null);
                    jEdit.closeBuffer(editPane, buf);
                    return newBuffer;
                }
                /*  if  "never mark untitled buffers dirty"
					 *  is selected, we might have contents in non-dirty
					 *  untitled buffers. We must clear those contents
					 *  if user requested new file.
					 */
                int l = buf.getLength();
                if (l > 0)
                    buf.remove(0, l);
                editPane.setBuffer(buf);
                return buf;
            }
        }
    }
    // Find the highest Untitled-n file
    int untitledCount = getNextUntitledBufferId();
    return openFile(editPane, dir, "Untitled-" + untitledCount, true, null);
}