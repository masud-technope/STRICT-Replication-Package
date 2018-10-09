private void writeArray(List stringList, Node appendTo) {
    Node arrayNode = createNode("array", appendTo);
    for (Iterator it = stringList.iterator(); it.hasNext(); ) {
        writeString((String) it.next(), arrayNode);
    }
}