//}}}
//{{{ getViews() method
/**
	 * Returns an array of all open views.
	 */
public static View[] getViews() {
    View[] views = new View[viewCount];
    View view = viewsFirst;
    for (int i = 0; i < viewCount; i++) {
        views[i] = view;
        view = view.next;
    }
    return views;
}