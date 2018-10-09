//}}}
//{{{ load() method
public void load() {
    DefaultTreeModel empty = new DefaultTreeModel(new DefaultMutableTreeNode(jEdit.getProperty("helpviewer.toc.loading")));
    toc.setModel(empty);
    toc.setRootVisible(true);
    ThreadUtilities.runInBackground(new Runnable() {

        public void run() {
            DefaultMutableTreeNode tocRoot = new HelpTOCLoader(nodes, helpViewer.getBaseURL()).createTOC();
            tocModel = new DefaultTreeModel(tocRoot);
            toc.setModel(tocModel);
            toc.setRootVisible(false);
            for (int i = 0; i < tocRoot.getChildCount(); i++) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tocRoot.getChildAt(i);
                toc.expandPath(new TreePath(node.getPath()));
            }
            if (helpViewer.getShortURL() != null)
                selectNode(helpViewer.getShortURL());
        }
    });
}