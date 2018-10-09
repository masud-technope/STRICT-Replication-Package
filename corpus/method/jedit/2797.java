@Override
public void endElement(String uri, String localName, String name) {
    if ("ENTRY".equals(name)) {
        result.addLast(new Entry(path, caret, selection, encoding, mode));
        path = null;
        caret = 0;
        selection = null;
        encoding = null;
        mode = null;
    } else if ("PATH".equals(name))
        path = charData.toString();
    else if ("CARET".equals(name)) {
        try {
            String s = charData.toString().trim();
            if (s.length() != charData.length()) {
                Log.log(Log.WARNING, this, "The caret position in recent.xml was wrong: '" + charData + "', fixing it");
            }
            caret = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            Log.log(Log.ERROR, this, "Unable to parse caret position " + charData);
        }
    } else if ("SELECTION".equals(name))
        selection = charData.toString();
    else if ("ENCODING".equals(name))
        encoding = charData.toString();
    else if ("MODE".equals(name))
        mode = charData.toString();
    charData.setLength(0);
}