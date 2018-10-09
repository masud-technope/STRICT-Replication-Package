@Override
protected void configureTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean focus) {
    setIcon(leaf ? FileCellRenderer.fileIcon : (expanded ? FileCellRenderer.openDirIcon : FileCellRenderer.dirIcon));
    setBorder(border);
}