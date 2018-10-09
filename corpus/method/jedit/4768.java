/**
	 * Creates a new view of a buffer.
	 * @param view An existing view
	 * @param buffer The buffer
	 * @param plainView If true, the view will not have dockable windows or
	 * tool bars.
	 *
	 * @since 4.1pre2
	 */
public static View newView(View view, Buffer buffer, boolean plainView) {
    View.ViewConfig config;
    if (view != null && (plainView == view.isPlainView())) {
        config = view.getViewConfig();
        config.x -= 20;
        config.y += 20;
    } else {
        config = new View.ViewConfig(plainView);
    }
    return newView(view, buffer, config);
}