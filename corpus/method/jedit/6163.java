//}}}
//{{{ cacheFlatNodes() method
public void cacheResultNodes(DefaultMutableTreeNode operNode) {
    resultNodes = new ArrayList<DefaultMutableTreeNode>(operNode.getChildCount());
    for (Enumeration e = operNode.children(); e.hasMoreElements(); ) resultNodes.add((DefaultMutableTreeNode) e.nextElement());
}