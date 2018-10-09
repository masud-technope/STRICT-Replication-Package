//}}}
//{{{ saveAbbrevs() method
private static void saveAbbrevs(Writer _out) throws Exception {
    BufferedWriter out = new BufferedWriter(_out);
    String lineSep = System.getProperty("line.separator");
    // write global abbrevs
    out.write("[global]");
    out.write(lineSep);
    saveAbbrevs(out, globalAbbrevs);
    // write mode abbrevs
    Enumeration<String> keys = modes.keys();
    Enumeration<Hashtable<String, String>> values = modes.elements();
    while (keys.hasMoreElements()) {
        out.write('[');
        out.write(keys.nextElement());
        out.write(']');
        out.write(lineSep);
        saveAbbrevs(out, values.nextElement());
    }
    out.close();
}