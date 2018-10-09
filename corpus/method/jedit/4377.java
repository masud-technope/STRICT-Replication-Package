//}}}
//{{{ createNode() method
private DefaultMutableTreeNode createNode(String href, String title) {
    DefaultMutableTreeNode node = new DefaultMutableTreeNode(new HelpTOCLoader.HelpNode(href, title), true);
    if (nodes != null) {
        nodes.put(href, node);
    }
    return node;
}