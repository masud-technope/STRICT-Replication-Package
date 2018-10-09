//}}}
//{{{ searchFailed() method
public void searchFailed() {
    caption.setText(jEdit.getProperty("hypersearch-results.no-results", new String[] { trimSearchString() }));
    // collapse all nodes, as suggested on user mailing list...
    for (int i = 0; i < resultTreeRoot.getChildCount(); i++) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) resultTreeRoot.getChildAt(i);
        resultTree.collapsePath(new TreePath(new Object[] { resultTreeRoot, node }));
    }
}