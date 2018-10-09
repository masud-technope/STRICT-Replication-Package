//{{{ update() method
private void update() {
    int size = Log.throwables.size();
    if (size != currentSize) {
        currentSize = size;
        if (size == 0) {
            setText(null);
            setToolTipText(size + " error");
        } else {
            setForeground(foregroundColor);
            setText(Integer.toString(size) + " error(s)");
            setToolTipText(size + " error(s)");
        }
    }
//}}}
}