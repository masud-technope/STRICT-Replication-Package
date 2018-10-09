//}}}
//{{{ setSearchString() method
/**
	 * Sets the search string.
	 *
	 * @param searchString The search string
	 * @param searchIn One of {@link #CURRENT_BUFFER}, {@link #ALL_BUFFERS}, or {@link #DIRECTORY}
	 * @since jEdit 4.0pre5
	 */
public void setSearchString(String searchString, int searchIn) {
    find.setText(null);
    replace.setText(null);
    if (searchString == null) {
        searchCurrentBuffer.setSelected(true);
        HistoryModel model = find.getModel();
        if (!model.isEmpty()) {
            find.setText(model.getItem(0));
            find.selectAll();
        }
    } else {
        if (searchString.indexOf('\n') == -1) {
            if (SearchAndReplace.getRegexp()) {
                find.setText(SearchAndReplace.escapeRegexp(searchString, true));
            } else
                find.setText(searchString);
            find.selectAll();
            searchCurrentBuffer.setSelected(true);
        } else if (searchIn == CURRENT_BUFFER) {
            searchSelection.setSelected(true);
            hyperSearch.setSelected(true);
        }
    }
    if (searchIn == CURRENT_BUFFER) {
        if (!searchSelection.isSelected()) {
            // might be already selected, see above.
            searchCurrentBuffer.setSelected(true);
            /* this property is only loaded and saved if
				 * the 'current buffer' file set is selected.
				 * otherwise, it defaults to on. */
            hyperSearch.setSelected(jEdit.getBooleanProperty("search.hypersearch.toggle"));
        }
    } else if (searchIn == ALL_BUFFERS) {
        searchAllBuffers.setSelected(true);
        hyperSearch.setSelected(true);
    } else if (searchIn == DIRECTORY) {
        SearchFileSet fileset = SearchAndReplace.getSearchFileSet();
        if (fileset instanceof DirectoryListSet) {
            filter.setText(((DirectoryListSet) fileset).getFileFilter());
            ///directoryField.setText(((DirectoryListSet)fileset)
            ///	.getDirectory());
            searchSubDirectories.setSelected(((DirectoryListSet) fileset).isRecursive());
        }
        hyperSearch.setSelected(true);
        searchDirectory.setSelected(true);
    }
    updateEnabled();
}