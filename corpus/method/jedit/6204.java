@Override
public void actionPerformed(ActionEvent evt) {
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
    ToStringNodes toStringNodes = new ToStringNodes();
    traverseNodes(operNode, toStringNodes);
    StringSelection selection = new StringSelection(toStringNodes.nodesString.toString());
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, null);
}