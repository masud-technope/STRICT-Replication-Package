@Override
public void endElement(String uri, String localName, String name) {
    if (name.equals("ENTRY")) {
        list.add(charData.toString());
        inEntry = false;
        charData.setLength(0);
    }
}