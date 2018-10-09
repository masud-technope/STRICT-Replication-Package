//{{{ TOCHandler constructor
 TOCHandler(DefaultMutableTreeNode root, String dir) {
    nodes = new Stack<DefaultMutableTreeNode>();
    node = root;
    this.dir = dir;
//}}}
}