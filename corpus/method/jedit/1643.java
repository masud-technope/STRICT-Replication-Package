public String getInvocationText() {
    SimpleNode node = getNode();
    if (node != null)
        return node.getText();
    else
        return "<invoked from Java code>";
}