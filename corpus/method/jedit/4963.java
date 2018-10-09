//}}}
//{{{ save() method
@Override
public void save() {
    if (killringXML == null)
        return;
    if (killringXML.hasChangedOnDisk()) {
        Log.log(Log.WARNING, KillRing.class, killringXML + " changed on disk; will not save killring" + " files");
        return;
    }
    Log.log(Log.MESSAGE, KillRing.class, "Saving " + killringXML);
    String lineSep = System.getProperty("line.separator");
    SettingsXML.Saver out = null;
    try {
        out = killringXML.openSaver();
        out.writeXMLDeclaration("1.1");
        out.write("<!DOCTYPE KILLRING SYSTEM \"killring.dtd\">");
        out.write(lineSep);
        out.write("<KILLRING>");
        out.write(lineSep);
        int size = getSize();
        for (int i = size - 1; i >= 0; i--) {
            out.write("<ENTRY>");
            out.write(XMLUtilities.charsToEntities(getElementAt(i), true));
            out.write("</ENTRY>");
            out.write(lineSep);
        }
        out.write("</KILLRING>");
        out.write(lineSep);
        out.finish();
    } catch (Exception e) {
        Log.log(Log.ERROR, KillRing.class, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}