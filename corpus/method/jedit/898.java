/**
		 * Creates a new <code>EntryCompare</code>
		 * Expanded branches are sorted, too, but keep with their parent entries
		 * @param sortBy The extended attribute by which to sort the entries.
		 * @param ascending If false, sort order is reversed.
		 */
 EntryCompare(String sortBy, boolean ascending) {
    this.sortMixFilesAndDirs = jEdit.getBooleanProperty("vfs.browser.sortMixFilesAndDirs");
    this.sortIgnoreCase = jEdit.getBooleanProperty("vfs.browser.sortIgnoreCase");
    this.sortAscending = ascending;
    this.sortAttribute = sortBy;
}