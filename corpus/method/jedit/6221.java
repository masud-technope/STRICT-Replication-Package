//}}}
//{{{ searchDone() method
/**
	 * @param searchNode the result node
	 * @param selectNode the node that must be selected, or null
	 * @since jEdit 4.3pre12
	 */
public void searchDone(final DefaultMutableTreeNode searchNode, final DefaultMutableTreeNode selectNode) {
    stop.setEnabled(false);
    final int nodeCount = searchNode.getChildCount();
    if (nodeCount < 1) {
        searchFailed();
        return;
    }
    caption.setText(jEdit.getProperty("hypersearch-results.done", new String[] { trimSearchString() }));
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            if (!multiStatus) {
                for (int i = 0; i < resultTreeRoot.getChildCount(); i++) {
                    resultTreeRoot.remove(0);
                }
            }
            resultTreeRoot.add(searchNode);
            resultTreeModel.reload(resultTreeRoot);
            for (int i = 0; i < nodeCount; i++) {
                TreePath lastNode = new TreePath(((DefaultMutableTreeNode) searchNode.getChildAt(i)).getPath());
                resultTree.expandPath(lastNode);
            }
            TreePath treePath;
            if (selectNode == null) {
                treePath = new TreePath(new Object[] { resultTreeRoot, searchNode });
            } else {
                treePath = new TreePath(selectNode.getPath());
            }
            resultTree.setSelectionPath(treePath);
            resultTree.scrollPathToVisible(treePath);
        }
    });
}