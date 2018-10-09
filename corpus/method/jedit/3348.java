public void startElement(String uri, String localName, String qName, Attributes attrs) {
    for (int i = 0; i < attrs.getLength(); i++) attribute(attrs.getQName(i), attrs.getValue(i));
}