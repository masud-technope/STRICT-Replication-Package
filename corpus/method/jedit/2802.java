//}}}
//{{{ save() method
public static void save() {
    if (recentXML == null)
        return;
    if (recentXML.hasChangedOnDisk()) {
        Log.log(Log.WARNING, BufferHistory.class, recentXML + " changed on disk; will not save recent" + " files");
        return;
    }
    Log.log(Log.MESSAGE, BufferHistory.class, "Saving " + recentXML);
    String lineSep = System.getProperty("line.separator");
    SettingsXML.Saver out = null;
    try {
        out = recentXML.openSaver();
        out.writeXMLDeclaration();
        out.write("<!DOCTYPE RECENT SYSTEM \"recent.dtd\">");
        out.write(lineSep);
        out.write("<RECENT>");
        out.write(lineSep);
        // Make a snapshot to avoid long locking period
        // which may be required by file I/O.
        List<Entry> snapshot = getHistory();
        for (Entry entry : snapshot) {
            out.write("<ENTRY>");
            out.write(lineSep);
            out.write("<PATH>");
            out.write(XMLUtilities.charsToEntities(entry.path, false));
            out.write("</PATH>");
            out.write(lineSep);
            out.write("<CARET>");
            out.write(String.valueOf(entry.caret));
            out.write("</CARET>");
            out.write(lineSep);
            if (entry.selection != null && entry.selection.length() > 0) {
                out.write("<SELECTION>");
                out.write(entry.selection);
                out.write("</SELECTION>");
                out.write(lineSep);
            }
            if (entry.encoding != null) {
                out.write("<ENCODING>");
                out.write(entry.encoding);
                out.write("</ENCODING>");
                out.write(lineSep);
            }
            if (entry.mode != null) {
                out.write("<MODE>");
                out.write(entry.mode);
                out.write("</MODE>");
                out.write(lineSep);
            }
            out.write("</ENTRY>");
            out.write(lineSep);
        }
        out.write("</RECENT>");
        out.write(lineSep);
        out.finish();
    } catch (Exception e) {
        Log.log(Log.ERROR, BufferHistory.class, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}