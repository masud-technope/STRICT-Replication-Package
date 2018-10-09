//{{{ getTreeCellRendererComponent() method
public final Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
    if (!propertyChangeListeners.containsKey(tree)) {
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!(evt.getSource() instanceof JTree))
                    return;
                JTree tree = (JTree) evt.getSource();
                if (tree.getCellRenderer() == EnhancedTreeCellRenderer.this)
                    tree.setCellRenderer(newInstance());
                tree.removePropertyChangeListener("UI", propertyChangeListeners.remove(tree));
            }
        };
        tree.addPropertyChangeListener("UI", propertyChangeListener);
        propertyChangeListeners.put(tree, propertyChangeListener);
    }
    super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
    configureTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
    return this;
}