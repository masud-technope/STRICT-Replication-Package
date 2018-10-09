//}}}
//{{{ getSelectedFiles() method
/**
	 * Return the selected files from the point of view of the
	 * given component. This may be the selected directory from the
	 * upper tree component of the browser (directory tree) or
	 * the selected files in the bottom tree component.
	 * This method is to be used by code running inside VFSBrowser
	 * such as a DynamicMenuProvider. Use the other method otherwise.
	 * The main difference is this function searches the component
	 * hierarchy for a {@link BrowserView.ParentDirectoryList} to get
	 * the list of currently selected files from there. Otherwise, it
	 * returns what {@link #getSelectedFiles()} would return.
	 * @param source the source component to start from when
	 * 		navigating the component hierarchy
	 * @since jEdit 4.4pre1
	 */
public VFSFile[] getSelectedFiles(Component source) {
    if (GUIUtilities.getComponentParent(source, BrowserView.ParentDirectoryList.class) != null) {
        Object[] selected = getBrowserView().getParentDirectoryList().getSelectedValuesList().toArray();
        VFSFile[] returnValue = new VFSFile[selected.length];
        System.arraycopy(selected, 0, returnValue, 0, selected.length);
        return returnValue;
    } else {
        return getSelectedFiles();
    }
}