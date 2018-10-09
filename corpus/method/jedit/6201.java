@Override
public void actionPerformed(ActionEvent evt) {
    TreePath path = resultTree.getSelectionPath();
    DefaultMutableTreeNode operNode = (DefaultMutableTreeNode) path.getLastPathComponent();
    HyperSearchFolderNode nodeObj = (HyperSearchFolderNode) operNode.getUserObject();
    String glob = "*";
    SearchFileSet dirList = SearchAndReplace.getSearchFileSet();
    if (dirList instanceof DirectoryListSet)
        glob = ((DirectoryListSet) dirList).getFileFilter();
    SearchAndReplace.setSearchFileSet(new DirectoryListSet(nodeObj.getNodeFile().getAbsolutePath(), glob, true));
    SearchDialog.showSearchDialog(view, null, SearchDialog.DIRECTORY);
}