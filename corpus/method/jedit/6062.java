//}}}
//{{{ loadRegisters() method
private static String stripEOLChars(String selection) throws IOException {
    boolean trailingEOL = selection.endsWith("\n") || selection.endsWith(System.getProperty("line.separator"));
    // Some Java versions return the clipboard
    // contents using the native line separator,
    // so have to convert it here
    BufferedReader in = new BufferedReader(new StringReader(selection));
    StringBuilder buf = new StringBuilder(selection.length());
    String line;
    while ((line = in.readLine()) != null) {
        // 24 Febuary 2004
        if (line.endsWith("\0")) {
            line = line.substring(0, line.length() - 1);
        }
        buf.append(line);
        buf.append('\n');
    }
    // remove trailing \n
    if (!trailingEOL && buf.length() != 0)
        buf.setLength(buf.length() - 1);
    return buf.toString();
}