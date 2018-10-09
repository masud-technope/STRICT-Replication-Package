@Override
public void actionPerformed(ActionEvent evt) {
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
    for (Enumeration e = operNode.children(); e.hasMoreElements(); ) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
        resultTree.collapsePath(new TreePath(node.getPath()));
    }
    resultTree.scrollPathToVisible(new TreePath(operNode.getPath()));
}