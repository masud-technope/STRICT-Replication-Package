//{{{ startElement() method
@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    String tag = pushElement(qName);
    if (tag.equals("DOCKABLE")) {
        dockableName = attrs.getValue("NAME");
        actions = "FALSE".equals(attrs.getValue("NO_ACTIONS"));
        String movableAttr = attrs.getValue("MOVABLE");
        if (movableAttr != null)
            movable = movableAttr.equalsIgnoreCase("TRUE");
    }
//}}}
}