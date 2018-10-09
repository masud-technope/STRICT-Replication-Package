//}}}
//{{{ incrementalSearch() method
private boolean incrementalSearch(int start, boolean reverse) {
    /* For example, if the current fileset is a directory,
		 * C+g will find the next match within that fileset.
		 * This can be annoying if you have just done an
		 * incremental search and want the next occurrence
		 * in the current buffer. */
    SearchAndReplace.setSearchFileSet(new CurrentBufferSet());
    SearchAndReplace.setSearchString(find.getText());
    SearchAndReplace.setReverseSearch(reverse);
    boolean ret = false;
    try {
        if (SearchAndReplace.find(view, view.getBuffer(), start, false, reverse))
            ret = true;
    } catch (Exception e) {
        Log.log(Log.DEBUG, this, e);
        ret = true;
    }
    if (ret) {
        if (wasError) {
            find.setForeground(defaultForeground);
            find.setBackground(defaultBackground);
            wasError = false;
        }
    } else {
        if (!wasError) {
            find.setForeground(errorForeground);
            find.setBackground(errorBackground);
            wasError = true;
        }
    }
    return ret;
}