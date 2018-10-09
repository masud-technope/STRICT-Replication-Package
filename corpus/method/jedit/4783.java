//}}}
//{{{ newFile() methods
/**
	 * Creates a new `untitled' file.
	 *
	 * @param view The view to create the file in
	 *
	 * @return the new buffer
	 */
public static Buffer newFile(View view) {
    return newFile(view == null ? null : view.getEditPane());
}