/**
        Set the node associated with the creation of this namespace.
        This is used in debugging and to support the getInvocationLine()
        and getInvocationText() methods.
    */
void setNode(SimpleNode node) {
    callerInfoNode = node;
}