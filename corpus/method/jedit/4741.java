//}}}
//{{{ Private members
/**
	 * Extract XML encoding name from PI.
	 */
private static String getXMLEncoding(String xmlPI) {
    if (!xmlPI.startsWith("<?xml"))
        return null;
    int index = xmlPI.indexOf("encoding=");
    if (index == -1 || index + 9 == xmlPI.length())
        return null;
    char ch = xmlPI.charAt(index + 9);
    int endIndex = xmlPI.indexOf(ch, index + 10);
    if (endIndex == -1)
        return null;
    String encoding = xmlPI.substring(index + 10, endIndex);
    try {
        if (Charset.isSupported(encoding)) {
            return encoding;
        } else {
            Log.log(Log.WARNING, XMLEncodingDetector.class, "XML PI specifies unsupported encoding: " + encoding);
        }
    } catch (IllegalCharsetNameException e) {
        Log.log(Log.WARNING, XMLEncodingDetector.class, "XML PI specifies illegal encoding: " + encoding, e);
    }
    return null;
}