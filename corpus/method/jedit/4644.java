/**
		 * Creates a new <code>DirectoryEntryCompare</code>.
		 * @param sortMixFilesAndDirs If false, directories are
		 * put at the top of the listing.
		 * @param sortIgnoreCase If false, upper case comes before
		 * lower case.
		 */
public  DirectoryEntryCompare(boolean sortMixFilesAndDirs, boolean sortIgnoreCase) {
    this.sortMixFilesAndDirs = sortMixFilesAndDirs;
    this.sortIgnoreCase = sortIgnoreCase;
}