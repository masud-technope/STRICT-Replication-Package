@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    inEntry = qName.equals("ENTRY");
}