public int getInvocationLine() {
    SimpleNode node = getNode();
    if (node != null)
        return node.getLineNumber();
    else
        return -1;
}