@Override
public boolean processNode(DefaultMutableTreeNode node) {
    Object userObject = node.getUserObject();
    if (userObject instanceof HyperSearchFileNode) {
        resultCount += ((HyperSearchFileNode) userObject).getCount();
        bufferCount++;
    }
    return true;
}