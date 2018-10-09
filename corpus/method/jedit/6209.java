//}}}
//{{{ removeAllNodes() method
private void removeAllNodes() {
    resultTreeRoot.removeAllChildren();
    resultTreeModel.reload(resultTreeRoot);
    setSearchStatus(null);
    hideDockable();
}