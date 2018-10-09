//}}}
//{{{ selectAll() method
private void selectAll() {
    selectAllInProgress = true;
    TreeNode[] path = new TreeNode[3];
    path[0] = root;
    for (int i = 0; i < root.getChildCount(); i++) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) root.getChildAt(i);
        path[1] = node;
        for (int j = 0; j < node.getChildCount(); j++) {
            DefaultMutableTreeNode node2 = (DefaultMutableTreeNode) node.getChildAt(j);
            path[2] = node2;
            bufferTree.getSelectionModel().addSelectionPath(new TreePath(path));
        }
    }
    selectAllInProgress = false;
    updateEnabled();
}