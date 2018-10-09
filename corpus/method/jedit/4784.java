/**
	 * Creates a new `untitled' file.
	 * @param view The view to create the file in
	 * @param dir The directory to create the file in
	 *
	 * @return the new buffer
	 *
	 * @since jEdit 3.1pre2
	 */
public static Buffer newFile(View view, String dir) {
    EditPane editPane = null;
    if (view != null) {
        editPane = view.getEditPane();
    } else {
        View v = getActiveView();
        if (v != null) {
            editPane = v.getEditPane();
        }
    }
    return newFile(editPane, dir);
}