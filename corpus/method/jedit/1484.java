/* Returns the root node of the AST.  It only makes sense to call
     this after a successful parse. */
Node rootNode() {
    return (Node) nodes.elementAt(0);
}