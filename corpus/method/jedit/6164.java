//}}}
//{{{ restoreFlatNodes() method
public void restoreFlatNodes(JTree resultTree, DefaultMutableTreeNode operNode) {
    for (DefaultMutableTreeNode element : resultNodes) {
        if (element.getUserObject() instanceof HyperSearchFileNode)
            ((HyperSearchFileNode) element.getUserObject()).showFullPath = true;
        operNode.insert(element, operNode.getChildCount());
    }
    ((DefaultTreeModel) resultTree.getModel()).nodeStructureChanged(operNode);
    for (Enumeration e = operNode.children(); e.hasMoreElements(); ) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
        resultTree.expandPath(new TreePath(node.getPath()));
    }
    resultTree.scrollPathToVisible(new TreePath(operNode.getPath()));
}