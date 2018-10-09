//{{{ startElement() method
public void startElement(String uri, String localName, String name, Attributes attrs) {
    tag = name;
    if (name.equals("ENTRY"))
        href = attrs.getValue("HREF");
//}}}
}