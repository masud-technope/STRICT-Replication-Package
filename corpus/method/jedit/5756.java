//}}}
//{{{ characters() method
public void characters(char[] c, int off, int len) {
    String tag = peekElement();
    if ("DESCRIPTION".equals(tag))
        description.append(c, off, len);
    else if ("LOCATION".equals(tag))
        location.append(c, off, len);
    else if ("COUNTRY".equals(tag))
        country.append(c, off, len);
    else if ("CONTINENT".equals(tag))
        continent.append(c, off, len);
}