//{{{ endElement() method
public void endElement(String uri, String localName, String name) {
    if (name == null)
        return;
    if (name.equals("TITLE")) {
        DefaultMutableTreeNode newNode = createNode(dir + href, title.toString());
        node.add(newNode);
        nodes.push(node);
        node = newNode;
        title.setLength(0);
    } else if (name.equals("ENTRY")) {
        node = nodes.pop();
        href = null;
    }
//}}}
}