/* A definite node is constructed from a specified number of
     children.  That number of nodes are popped from the stack and
     made the children of the definite node.  Then the definite node
     is pushed on to the stack. */
void closeNodeScope(Node n, int num) {
    mk = ((Integer) marks.pop()).intValue();
    while (num-- > 0) {
        Node c = popNode();
        c.jjtSetParent(n);
        n.jjtAddChild(c, num);
    }
    n.jjtClose();
    pushNode(n);
    node_created = true;
}