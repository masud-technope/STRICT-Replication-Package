@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
    if ("plugin".equals(localName)) {
        pluginSet.add(attrs.getValue("jar"));
    }
}