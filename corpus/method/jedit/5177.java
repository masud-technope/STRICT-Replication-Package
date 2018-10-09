/**
	 * Creates a new buffer update message.
	 * @param buffer The buffer
	 * @param what What happened
	 */
public  BufferUpdate(Buffer buffer, View view, Object what) {
    super(buffer);
    this.view = view;
    if (what == null)
        throw new NullPointerException("What must be non-null");
    this.what = what;
}