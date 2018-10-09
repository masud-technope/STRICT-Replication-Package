//{{{ updateEnabled() method
private void updateEnabled() {
    TreePath[] paths = bufferTree.getSelectionPaths();
    boolean enabled = false;
    if (paths != null) {
        for (TreePath tp : paths) {
            Object[] path = tp.getPath();
            if (path.length == 3)
                enabled = true;
        }
    }
    if (reload != null)
        reload.setEnabled(enabled);
    if (ignore != null)
        ignore.setEnabled(enabled);
}