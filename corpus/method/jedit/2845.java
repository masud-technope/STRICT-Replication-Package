//}}}
//{{{ Package-private members
//{{{ handleMessage
/**
	 * This method is called by BufferSetManager to signal that this
	 * BufferSet needs to react to a change in the sorting properties.
	 */
void propertiesChanged() {
    if (jEdit.getBooleanProperty("sortBuffers")) {
        // set the appropriate sorter
        if (jEdit.getBooleanProperty("sortByName"))
            sorter = nameSorter;
        else
            sorter = pathSorter;
        sort();
    } else {
        // user has elected not to sort BufferSets
        sorter = null;
    }
}