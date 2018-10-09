//}}}
//{{{ showSearchDialog() method
/**
	 * Displays a search and replace dialog box, reusing an existing one
	 * if necessary.
	 * @param view The view
	 * @param searchString The search string
	 * @param searchIn One of CURRENT_BUFFER, ALL_BUFFERS, or DIRECTORY
	 * @since jEdit 4.0pre6
	 */
public static void showSearchDialog(View view, String searchString, int searchIn) {
    final SearchDialog dialog = getSearchDialog(view);
    dialog.setSearchString(searchString, searchIn);
    // -- Better is to use requestFocusInWindow
    if (SwingUtilities.isEventDispatchThread()) {
        dialog.setVisible(true);
        dialog.toFront();
        dialog.requestFocusInWindow();
        dialog.find.requestFocusInWindow();
    } else {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                dialog.setVisible(true);
                dialog.toFront();
                // Ensure that the dialog gets the focus. Just bringing
                // it to front just not necessarily give it the focus.
                dialog.requestFocusInWindow();
                // Given that the dialog has the focus, set the focus
                // to the 'find' field.
                dialog.find.requestFocusInWindow();
            }
        });
    }
}