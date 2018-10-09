@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
    if (localName.equals("plugin")) {
        String jarName = attrs.getValue("jar");
        String name = attrs.getValue("name");
        selectedPlugins.add(name);
        jarNames.add(jarName);
    }
}