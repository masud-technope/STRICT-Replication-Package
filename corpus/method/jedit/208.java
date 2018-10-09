private void writeBoolean(Boolean b, Node appendTo) {
    Element booleanNode = null;
    if (b.booleanValue()) {
        booleanNode = this.document.createElement("true");
    } else {
        booleanNode = this.document.createElement("false");
    }
    appendTo.appendChild(booleanNode);
}