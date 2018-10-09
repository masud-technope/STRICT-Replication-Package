@Override
protected void configureTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    if (node.getParent() == tree.getModel().getRoot())
        setFont(groupFont);
    else
        setFont(entryFont);
    setIcon(null);
}