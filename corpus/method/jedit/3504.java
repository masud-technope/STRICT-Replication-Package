//}}}
//{{{ reload() method
private void action(String action) {
    TreePath[] paths = bufferTree.getSelectionPaths();
    if (paths == null || paths.length == 0)
        return;
    int row = bufferTree.getRowForPath(paths[0]);
    for (TreePath path : paths) {
        // is it a header?
        if (path.getPathCount() == 2)
            continue;
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (!(node.getUserObject() instanceof String))
            return;
        Buffer buffer = jEdit.getBuffer((String) node.getUserObject());
        if (buffer == null)
            return;
        if ("RELOAD".equals(action))
            buffer.reload(view);
        else {
            buffer.setAutoReload(false);
            buffer.setAutoReloadDialog(false);
        }
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        parent.remove(node);
    }
    bufferTreeModel.reload(root);
    // we expand those that are non-empty, and
    // remove those that are empty
    TreeNode[] nodes = { root, null };
    // remove empty category branches
    for (int j = 0; j < root.getChildCount(); j++) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(j);
        if (root.getChildAt(j).getChildCount() == 0) {
            root.remove(j);
            j--;
        } else {
            nodes[1] = node;
            bufferTree.expandPath(new TreePath(nodes));
        }
    }
    if (root.getChildCount() == 0)
        dispose();
    else {
        if (row >= bufferTree.getRowCount())
            row = bufferTree.getRowCount() - 1;
        TreePath path = bufferTree.getPathForRow(row);
        if (path.getPathCount() == 2) {
            // selected a header; skip to the next row
            bufferTree.setSelectionRow(row + 1);
        } else
            bufferTree.setSelectionPath(path);
    }
}