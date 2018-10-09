//}}}
//{{{ doHyperSearch() method
private int doHyperSearch(Buffer buffer, int start, int end) throws Exception {
    if (matcher instanceof BoyerMooreSearchMatcher)
        setCancellable(true);
    else
        setCancellable(false);
    HyperSearchFileNode hyperSearchFileNode = new HyperSearchFileNode(buffer.getPath());
    DefaultMutableTreeNode bufferNode = new DefaultMutableTreeNode(hyperSearchFileNode);
    int resultCount = doHyperSearch(buffer, start, end, bufferNode);
    hyperSearchFileNode.setCount(resultCount);
    if (resultCount != 0)
        rootSearchNode.insert(bufferNode, rootSearchNode.getChildCount());
    setCancellable(true);
    return resultCount;
}