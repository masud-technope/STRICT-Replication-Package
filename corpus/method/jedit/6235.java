//}}}
//{{{ traverseNodes() method
public static boolean traverseNodes(DefaultMutableTreeNode node, HyperSearchTreeNodeCallback callbackInterface) {
    if (!callbackInterface.processNode(node))
        return false;
    for (Enumeration e = node.children(); e.hasMoreElements(); ) {
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) e.nextElement();
        if (!traverseNodes(childNode, callbackInterface))
            return false;
    }
    return true;
}