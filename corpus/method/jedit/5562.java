@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    charData.setLength(0);
    for (int i = 0; i < attrs.getLength(); i++) {
        String name = attrs.getQName(i);
        String value = attrs.getValue(i);
        attribute(name, value);
    }
}