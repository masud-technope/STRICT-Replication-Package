//}}}
//{{{ selectNode() method
public void selectNode(String shortURL) {
    if (tocModel == null)
        return;
    final DefaultMutableTreeNode node = nodes.get(shortURL);
    if (node == null)
        return;
    EventQueue.invokeLater(new Runnable() {

        public void run() {
            TreePath path = new TreePath(tocModel.getPathToRoot(node));
            toc.expandPath(path);
            toc.setSelectionPath(path);
            toc.scrollPathToVisible(path);
        }
    });
}