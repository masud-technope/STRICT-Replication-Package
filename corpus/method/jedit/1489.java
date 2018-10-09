/* A conditional node is constructed if its condition is true.  All
     the nodes that have been pushed since the node was opened are
     made children of the the conditional node, which is then pushed
     on to the stack.  If the condition is false the node is not
     constructed and they are left on the stack. */
void closeNodeScope(Node n, boolean condition) {
    if (condition) {
        int a = nodeArity();
        mk = ((Integer) marks.pop()).intValue();
        while (a-- > 0) {
            Node c = popNode();
            c.jjtSetParent(n);
            n.jjtAddChild(c, a);
        }
        n.jjtClose();
        pushNode(n);
        node_created = true;
    } else {
        mk = ((Integer) marks.pop()).intValue();
        node_created = false;
    }
}