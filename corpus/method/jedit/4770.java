//}}}
//{{{ closeView() method
/**
	 * Closes a view.
	 *
	 * jEdit will exit if this was the last open view.
	 */
public static void closeView(View view) {
    closeView(view, true);
}