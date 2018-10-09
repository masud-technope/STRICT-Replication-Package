public int getErrorLineNumber() {
    if (node != null)
        return node.getLineNumber();
    else
        return -1;
}