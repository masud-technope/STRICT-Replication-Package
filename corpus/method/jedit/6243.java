@Override
public void exportToClipboard(JComponent comp, Clipboard clip, int action) throws IllegalStateException {
    TreePath[] paths = resultTree.getSelectionPaths();
    ToStringNodes toStringNodes = new ToStringNodes();
    for (TreePath path : paths) {
        DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
        toStringNodes.processNode(operNode);
    }
    StringSelection selection = new StringSelection(toStringNodes.nodesString.toString());
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, null);
}