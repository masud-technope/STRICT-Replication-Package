public void valueChanged(TreeSelectionEvent evt) {
    if (selectAllInProgress)
        return;
    updateEnabled();
    TreePath[] paths = bufferTree.getSelectionPaths();
    if (paths == null || paths.length == 0)
        return;
    TreePath path = paths[paths.length - 1];
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
    if (node.getUserObject() instanceof String) {
        Buffer buffer = jEdit.getBuffer((String) node.getUserObject());
        if (buffer != null)
            view.showBuffer(buffer);
    }
}