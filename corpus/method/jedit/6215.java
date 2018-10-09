//{{{ showPopupMenu method
private void showPopupMenu(MouseEvent evt) {
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
    popupMenu = new JPopupMenu();
    Object userObj = node.getUserObject();
    if (userObj instanceof HyperSearchNode) {
        popupMenu.add(new GoToNodeAction("hypersearch-results.open", M_OPEN));
        popupMenu.add(new GoToNodeAction("hypersearch-results.open-view", M_OPEN_NEW_VIEW));
        popupMenu.add(new GoToNodeAction("hypersearch-results.open-plain-view", M_OPEN_NEW_PLAIN_VIEW));
        popupMenu.add(new GoToNodeAction("hypersearch-results.open-split", M_OPEN_NEW_SPLIT));
    }
    if (!(userObj instanceof HyperSearchFolderNode))
        popupMenu.add(new RemoveTreeNodeAction());
    if (!(userObj instanceof HyperSearchResult))
        popupMenu.add(new ExpandChildTreeNodesAction());
    if (userObj instanceof HyperSearchFolderNode || userObj instanceof HyperSearchOperationNode) {
        popupMenu.add(new CollapseChildTreeNodesAction());
        if (userObj instanceof HyperSearchFolderNode) {
            popupMenu.add(new NewSearchAction());
        } else {
            popupMenu.add(new JPopupMenu.Separator());
            HyperSearchOperationNode resultNode = (HyperSearchOperationNode) userObj;
            JCheckBoxMenuItem chkItem = new JCheckBoxMenuItem(jEdit.getProperty("hypersearch-results.tree-view"), resultNode.isTreeViewDisplayed());
            chkItem.addActionListener(new TreeDisplayAction());
            popupMenu.add(chkItem);
            popupMenu.add(new RedoSearchAction((HyperSearchOperationNode) userObj));
        }
    }
    popupMenu.add(new CopyToClipboardAction());
    GenericGUIUtilities.showPopupMenu(popupMenu, evt.getComponent(), evt.getX(), evt.getY());
    evt.consume();
//}}}
}