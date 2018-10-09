private void writeString(String string, Node appendTo) {
    Element stringNode = this.document.createElement("string");
    stringNode.appendChild(this.document.createTextNode(string));
    appendTo.appendChild(stringNode);
}