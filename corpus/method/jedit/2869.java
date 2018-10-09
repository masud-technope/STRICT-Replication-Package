//}}}
//{{{ addBuffer() methods
/**
	 * Add a buffer into the current editPane of the given view.
	 * If the view is null, it will be added to the current
	 * editPane of the active view.
	 * @param view a view (or null)
	 * @param buffer the buffer to add
	 */
public void addBuffer(View view, Buffer buffer) {
    EditPane editPane = view == null ? null : view.getEditPane();
    addBuffer(editPane, buffer);
}