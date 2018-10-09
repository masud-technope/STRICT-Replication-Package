//}}}
//{{{ find() method
/**
	 * Finds the next instance of the search string in the specified
	 * buffer.
	 * @param view The view
	 * @param buffer The buffer
	 * @param start Location where to start the search
	 */
public static boolean find(View view, Buffer buffer, int start) throws Exception {
    return find(view, buffer, start, false, false);
}