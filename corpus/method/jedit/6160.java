//}}}
//{{{ insertTreeNodes() method
public void insertTreeNodes(JTree resultTree, DefaultMutableTreeNode operNode) {
    String fileSep = System.getProperty("file.separator");
    String fileSepRegex = System.getProperty("file.separator");
    if (fileSep.equals("\\"))
        fileSepRegex = "\\\\";
    String[] topPathTmp = null;
    int topPathNdx = -1;
    for (DefaultMutableTreeNode fileTreeNode : resultNodes) {
        Object obj = fileTreeNode.getUserObject();
        if (!(obj instanceof HyperSearchFileNode))
            continue;
        HyperSearchFileNode fileNode = (HyperSearchFileNode) obj;
        int pos = fileNode.path.lastIndexOf(fileSep);
        String pathName = fileNode.path.substring(0, pos);
        String[] paths = pathName.split(fileSepRegex);
        if (topPathNdx == -1) {
            topPathNdx = paths.length;
            topPathTmp = paths;
        } else if (paths.length < topPathNdx) {
            topPathNdx = paths.length;
            topPathTmp = paths;
        } else {
            for (int ndx = 0; ndx < topPathNdx; ndx++) {
                if (!paths[ndx].equals(topPathTmp[ndx])) {
                    topPathNdx = ndx;
                    break;
                }
            }
        }
    }
    String[] topPath = new String[topPathNdx];
    String topPathPath = "";
    for (int ndx = 0; ndx < topPathNdx; ndx++) {
        topPath[ndx] = topPathTmp[ndx];
        topPathPath = topPathPath.concat(topPath[ndx] + fileSep);
    }
    Map<String, DefaultMutableTreeNode> treeNodes = new HashMap<String, DefaultMutableTreeNode>();
    HyperSearchFolderNode folderNode = new HyperSearchFolderNode(new File(topPathPath), true);
    DefaultMutableTreeNode folderTreeNode = new DefaultMutableTreeNode(folderNode);
    operNode.insert(folderTreeNode, operNode.getChildCount());
    treeNodes.put(topPathPath, folderTreeNode);
    for (DefaultMutableTreeNode fileTreeNode : resultNodes) {
        Object obj = fileTreeNode.getUserObject();
        if (!(obj instanceof HyperSearchFileNode))
            continue;
        HyperSearchFileNode fileNode = (HyperSearchFileNode) obj;
        fileNode.showFullPath = false;
        int pos = fileNode.path.lastIndexOf(fileSep);
        String pathName = fileNode.path.substring(0, pos);
        String[] paths = pathName.split(fileSepRegex);
        DefaultMutableTreeNode insNode = folderTreeNode;
        String partialPath = topPathPath;
        for (int ndx = topPathNdx; ndx < paths.length; ndx++) {
            partialPath = partialPath.concat(paths[ndx] + fileSep);
            DefaultMutableTreeNode tmpNode = treeNodes.get(partialPath);
            if (tmpNode == null) {
                HyperSearchFolderNode tmpFolderNode = new HyperSearchFolderNode(new File(partialPath), false);
                tmpNode = new DefaultMutableTreeNode(tmpFolderNode);
                insNode.insert(tmpNode, insNode.getChildCount());
                treeNodes.put(partialPath, tmpNode);
            }
            insNode = tmpNode;
        }
        insNode.insert(fileTreeNode, insNode.getChildCount());
        treeNodes.put(fileNode.path, insNode);
    }
}