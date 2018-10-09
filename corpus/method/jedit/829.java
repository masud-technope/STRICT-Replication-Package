// }}}
//{{{ getLastVisitedPath() method
/**
	 * Returns the last path visited by VFSBrowser. If no path was ever
	 * visited, returns <code>null</code>,
	 * @since 5.1
	 */
public static String getLastVisitedPath() {
    HistoryModel pathModel = HistoryModel.getModel("vfs.browser.path");
    if (pathModel.getSize() == 0)
        return null;
    else
        return pathModel.getItem(0);
}