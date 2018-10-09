private void goToSelectedNode(int mode) {
    TreePath path = resultTree.getSelectionPath();
    if (path == null)
        return;
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
    Object value = node.getUserObject();
    // do nothing if clicked "foo (showing n occurrences in m files)"
    if (node.getParent() != resultTreeRoot && value instanceof HyperSearchNode) {
        HyperSearchNode n = (HyperSearchNode) value;
        Buffer buffer = n.getBuffer(view);
        if (buffer == null)
            return;
        EditPane pane;
        switch(mode) {
            case M_OPEN:
                pane = view.goToBuffer(buffer);
                break;
            case M_OPEN_NEW_VIEW:
                pane = jEdit.newView(view, buffer, false).getEditPane();
                break;
            case M_OPEN_NEW_PLAIN_VIEW:
                pane = jEdit.newView(view, buffer, true).getEditPane();
                break;
            case M_OPEN_NEW_SPLIT:
                pane = view.splitHorizontally();
                break;
            default:
                throw new IllegalArgumentException("Bad mode: " + mode);
        }
        n.goTo(pane);
    }
}