//}}}
//{{{ expandAllNodes() method
public void expandAllNodes(DefaultMutableTreeNode node) {
    traverseNodes(node, new TreeNodeCallbackAdapter() {

        @Override
        public boolean processNode(DefaultMutableTreeNode node) {
            resultTree.expandPath(new TreePath(node.getPath()));
            return true;
        }
    });
}