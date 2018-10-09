//}}}
//{{{ setSearchFileSet() method
/**
	 * Sets the current search file set.
	 * @param fileset The file set to perform searches in
	 * @see AllBufferSet
	 * @see CurrentBufferSet
	 * @see DirectoryListSet
	 */
public static void setSearchFileSet(SearchFileSet fileset) {
    SearchAndReplace.fileset = fileset;
    EditBus.send(new SearchSettingsChanged(null));
}