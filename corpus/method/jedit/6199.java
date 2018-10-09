@Override
public void actionPerformed(ActionEvent evt) {
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
    expandAllNodes(operNode);
}