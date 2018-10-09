//}}}
//{{{ save() method
/**
	 * Saves this buffer to the specified path name, or the current path
	 * name if it's null.
	 * @param view The view
	 * @param path The path name to save the buffer to, or null to use
	 * @return true if the buffer was successfully saved
	 * the existing path
	 */
public boolean save(View view, String path) {
    return save(view, path, true, false);
}