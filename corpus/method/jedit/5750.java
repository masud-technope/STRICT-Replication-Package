//}}}
//{{{ startElement() method
public void startElement(String uri, String localName, String tag, Attributes attrs) {
    tag = pushElement(tag);
    if (tag.equals("MIRROR")) {
        mirror = new MirrorList.Mirror();
        id = attrs.getValue("ID");
    }
}