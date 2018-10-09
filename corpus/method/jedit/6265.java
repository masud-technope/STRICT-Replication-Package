//}}}
//{{{ hyperSearch() method
/**
	 * Performs a HyperSearch.
	 * @param view The view
	 * @param selection If true, will only search in the current selection.
	 * Note that the file set must be the current buffer file set for this
	 * to work.
	 * @since jEdit 4.0pre1
	 */
public static boolean hyperSearch(View view, boolean selection) {
    // component that will parent any dialog boxes
    Component comp = SearchDialog.getSearchDialog(view);
    if (comp == null)
        comp = view;
    record(view, "hyperSearch(view," + selection + ')', false, !selection);
    view.getDockableWindowManager().addDockableWindow(HyperSearchResults.NAME);
    HyperSearchResults results = (HyperSearchResults) view.getDockableWindowManager().getDockable(HyperSearchResults.NAME);
    results.searchStarted();
    try {
        SearchMatcher matcher = getSearchMatcher();
        if (matcher == null) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            results.searchFailed();
            return false;
        }
        Selection[] s;
        if (selection) {
            s = view.getTextArea().getSelection();
            if (s == null) {
                results.searchFailed();
                return false;
            }
        } else
            s = null;
        ThreadUtilities.runInBackground(new HyperSearchRequest(view, matcher, results, s));
        return true;
    } catch (Exception e) {
        results.searchFailed();
        handleError(comp, e);
        return false;
    }
}