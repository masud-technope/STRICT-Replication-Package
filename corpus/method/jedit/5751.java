//}}}
//{{{ endElement() method
public void endElement(String uri, String localName, String tag) {
    popElement();
    if (tag.equals("MIRROR")) {
        mirror.id = id;
        mirror.description = description.toString();
        mirror.location = location.toString();
        mirror.country = country.toString();
        mirror.continent = continent.toString();
        mirrors.add(mirror);
        description.setLength(0);
        location.setLength(0);
        country.setLength(0);
        continent.setLength(0);
    }
}