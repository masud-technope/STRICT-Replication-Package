@Override
public boolean processNode(DefaultMutableTreeNode node) {
    Object userObject = node.getUserObject();
    if (userObject instanceof HyperSearchFileNode)
        nodesString.append(((HyperSearchFileNode) userObject).path);
    else if (userObject instanceof HyperSearchResult) {
        HyperSearchResult hsr = (HyperSearchResult) userObject;
        // Copy the ORIGINAL line from the buffer!
        nodesString.append(hsr.buffer == null ? hsr.toString() : hsr.buffer.getLineText(hsr.line));
    } else
        nodesString.append(userObject.toString());
    nodesString.append('\n');
    return true;
}