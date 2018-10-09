public String getErrorSourceFile() {
    if (node != null)
        return node.getSourceFile();
    else
        return "<unknown file>";
}