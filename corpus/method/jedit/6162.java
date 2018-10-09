//}}}
//{{{ removeNodeFromCache() method
public static void removeNodeFromCache(MutableTreeNode mnode) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) mnode;
    if (node.getUserObject() instanceof HyperSearchOperationNode)
        return;
    DefaultMutableTreeNode tmpNode = node;
    while ((tmpNode = (DefaultMutableTreeNode) tmpNode.getParent()) != null) {
        if (!(tmpNode.getUserObject() instanceof HyperSearchOperationNode))
            continue;
        HyperSearchOperationNode operNode = (HyperSearchOperationNode) tmpNode.getUserObject();
        if (operNode.resultNodes != null) {
            // the nodes aren't cached so no need to remove the node from cache
            operNode.resultNodes.remove(node);
        }
        break;
    }
}