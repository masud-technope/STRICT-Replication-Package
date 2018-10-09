private void writeKey(String key, Node appendTo) {
    Element keyNode = this.document.createElement("key");
    appendTo.appendChild(keyNode);
    keyNode.appendChild(this.document.createTextNode(key));
}