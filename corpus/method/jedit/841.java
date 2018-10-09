@Override
public void setItem(Object item) {
    if (item == current) {
        // selected...
        if (item != null) {
            GlobVFSFileFilter filter = (GlobVFSFileFilter) item;
            current = new GlobVFSFileFilter(filter.getGlob());
            setText(current.getGlob());
        }
        return;
    }
    if (item != null) {
        // non-editable mode by the handler above.
        if (!(item instanceof GlobVFSFileFilter))
            return;
        GlobVFSFileFilter filter = (GlobVFSFileFilter) item;
        filter = new GlobVFSFileFilter(filter.getGlob());
        setText(filter.getGlob());
        addCurrentToHistory();
        current = filter;
    } else {
        setText("*");
        current = new GlobVFSFileFilter("*");
    }
}