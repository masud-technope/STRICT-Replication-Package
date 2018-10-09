//}}}
//{{{ visitBuffers() method
private void visitBuffers(final ResultVisitor visitor, final Buffer buffer) {
    // impl note: since multi-level hierarchies now allowed,
    // use traverseNodes to process HyperSearchResult nodes
    traverseNodes(resultTreeRoot, new TreeNodeCallbackAdapter() {

        @Override
        public boolean processNode(DefaultMutableTreeNode node) {
            Object userObject = node.getUserObject();
            if (!(userObject instanceof HyperSearchResult))
                return true;
            HyperSearchResult result = (HyperSearchResult) userObject;
            if (result.pathEquals(buffer.getSymlinkPath()))
                visitor.visit(buffer, result);
            return true;
        }
    });
}