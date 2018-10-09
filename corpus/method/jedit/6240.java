//{{{ getTreeCellRendererComponent() method
@Override
protected void configureTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    setIcon(null);
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    if (node.getUserObject() instanceof HyperSearchOperationNode) {
        setFont(boldFont);
        CountNodes countNodes = new CountNodes();
        traverseNodes(node, countNodes);
        setText(jEdit.getProperty("hypersearch-results.result-caption", new Object[] { node.toString(), Integer.valueOf(countNodes.resultCount), Integer.valueOf(countNodes.bufferCount) }));
    } else if (node.getUserObject() instanceof HyperSearchFolderNode) {
        setFont(plainFont);
        setText(node.toString() + " (" + node.getChildCount() + " files/folders)");
    } else if (node.getUserObject() instanceof HyperSearchFileNode) {
        // file name
        setFont(boldFont);
        HyperSearchFileNode hyperSearchFileNode = (HyperSearchFileNode) node.getUserObject();
        setText(jEdit.getProperty("hypersearch-results.file-caption", new Object[] { hyperSearchFileNode, Integer.valueOf(hyperSearchFileNode.getCount()), Integer.valueOf(node.getChildCount()) }));
    } else {
        setFont(plainFont);
    }
//}}}
}