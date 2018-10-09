public SimpleNode popNode() {
    if (// number of child nodes 
    jjtree.nodeArity() > 0)
        return (SimpleNode) jjtree.popNode();
    else
        return null;
}