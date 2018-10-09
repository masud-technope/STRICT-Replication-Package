//}}}
//{{{ getActiveView() method
/**
	 * Returns the currently focused view.
	 * @since jEdit 4.1pre1
	 */
public static View getActiveView() {
    if (activeView == null) {
        // eg user just closed a view and didn't focus another
        return viewsFirst;
    } else
        return activeView;
}