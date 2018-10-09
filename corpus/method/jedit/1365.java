public String getErrorText() {
    if (node != null)
        return node.getText();
    else
        return "<unknown error>";
}