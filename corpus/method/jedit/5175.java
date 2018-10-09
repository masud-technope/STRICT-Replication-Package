/**
	 * @param editPane the editPane that sent the message
	 * @param newBuffer the buffer that will soon be displayed.
	 */
public  BufferChanging(EditPane editPane, Buffer newBuffer) {
    super(editPane, EditPaneUpdate.BUFFER_CHANGING);
    if (newBuffer == null) {
        String s = Arrays.toString(Thread.currentThread().getStackTrace());
        Log.log(Log.ERROR, this, "BufferChanging to null Buffer? Emit PositionChanging instead." + s);
    }
    m_buffer = newBuffer;
}