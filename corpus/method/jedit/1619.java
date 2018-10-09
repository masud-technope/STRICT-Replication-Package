/**
    */
SimpleNode getNode() {
    if (callerInfoNode != null)
        return callerInfoNode;
    if (parent != null)
        return parent.getNode();
    else
        return null;
}