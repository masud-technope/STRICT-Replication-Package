//}}}
//{{{ startElement() method
public void startElement(String uri, String localName, String tag, Attributes attrs) {
    pushElement(tag);
    serviceName = attrs.getValue("NAME");
    serviceClass = attrs.getValue("CLASS");
}