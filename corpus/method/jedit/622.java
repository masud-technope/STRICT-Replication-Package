//}}}
//{{{ startElement() method
@Override
public void startElement(String uri, String localName, String qName, Attributes attrs) {
    String tag = pushElement(qName);
    if (tag.equals("ACTION")) {
        actionName = attrs.getValue("NAME");
        noRepeat = "TRUE".equals(attrs.getValue("NO_REPEAT"));
        noRecord = "TRUE".equals(attrs.getValue("NO_RECORD"));
        noRememberLast = "TRUE".equals(attrs.getValue("NO_REMEMBER_LAST"));
        code.setLength(0);
        isSelected.setLength(0);
    }
}