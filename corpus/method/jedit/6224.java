//}}}
//{{{ removeSelectedNode() method
private void removeSelectedNode() {
    TreePath path = resultTree.getSelectionPath();
    if (path == null)
        return;
    MutableTreeNode value = (MutableTreeNode) path.getLastPathComponent();
    if (path.getPathCount() > 1) {
        // Adjust selection so that repeating some removals
        // behave naturally.
        TreePath parentPath = path.getParentPath();
        MutableTreeNode parent = (MutableTreeNode) parentPath.getLastPathComponent();
        int removingIndex = parent.getIndex(value);
        int nextIndex = removingIndex + 1;
        if (nextIndex < parent.getChildCount()) {
            TreeNode next = parent.getChildAt(nextIndex);
            resultTree.setSelectionPath(parentPath.pathByAddingChild(next));
        } else {
            resultTree.setSelectionPath(parentPath);
        }
        resultTreeModel.removeNodeFromParent(value);
    }
    HyperSearchOperationNode.removeNodeFromCache(value);
    if (resultTreeRoot.getChildCount() == 0) {
        hideDockable();
    }
}