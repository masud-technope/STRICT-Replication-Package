//}}}
//{{{ saveAbbrevs() method
private static void saveAbbrevs(Writer out, Hashtable<String, String> abbrevs) throws Exception {
    String lineSep = System.getProperty("line.separator");
    Enumeration<String> keys = abbrevs.keys();
    Enumeration<String> values = abbrevs.elements();
    while (keys.hasMoreElements()) {
        String abbrev = keys.nextElement();
        out.write(abbrev);
        out.write('|');
        out.write(values.nextElement());
        out.write(lineSep);
    }
}