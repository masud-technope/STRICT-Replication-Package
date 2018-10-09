//{{{ expandOrGotoPath() method
private void expandOrGotoPath(TreePath path) {
    if (path != null) {
        if (!isPathSelected(path))
            setSelectionPath(path);
        Object obj = ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
        if (obj instanceof HelpTOCLoader.HelpNode) {
            HelpTOCLoader.HelpNode node = (HelpTOCLoader.HelpNode) obj;
            helpViewer.gotoURL(node.href, true, 0);
        } else {
            this.expandPath(path);
        }
    }
//}}}
}