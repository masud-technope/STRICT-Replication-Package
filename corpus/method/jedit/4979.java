//{{{ startElement() method
@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    registerName = attrs.getValue("NAME");
    inRegister = "REGISTER".equals(qName);
//}}}
}