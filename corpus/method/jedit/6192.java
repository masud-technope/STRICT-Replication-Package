@Override
public void actionPerformed(ActionEvent evt) {
    JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) evt.getSource();
    boolean curState = menuItem.isSelected();
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
    HyperSearchOperationNode operNodeObj = (HyperSearchOperationNode) operNode.getUserObject();
    if (curState)
        operNodeObj.cacheResultNodes(operNode);
    operNode.removeAllChildren();
    if (curState) {
        Exception excp = null;
        try {
            operNodeObj.insertTreeNodes(resultTree, operNode);
        } catch (Exception ex) {
            operNodeObj.restoreFlatNodes(resultTree, operNode);
            menuItem.setSelected(false);
            excp = ex;
        } finally {
            ((DefaultTreeModel) resultTree.getModel()).nodeStructureChanged(operNode);
            expandAllNodes(operNode);
            resultTree.scrollPathToVisible(new TreePath(operNode.getPath()));
        }
        if (excp != null)
            throw new RuntimeException(excp);
    } else
        operNodeObj.restoreFlatNodes(resultTree, operNode);
    operNodeObj.setTreeViewDisplayed(menuItem.isSelected());
}