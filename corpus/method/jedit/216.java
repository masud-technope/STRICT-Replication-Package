//----------------------------------------------------------------------
private Node createNode(String tag, Node appendTo) {
    Node node = this.document.createElement(tag);
    appendTo.appendChild(node);
    return node;
}