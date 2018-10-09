//}}}
//{{{ savePerspective() method
public static void savePerspective(boolean autosave) {
    if (!isPerspectiveEnabled() || !jEdit.isStartupDone())
        return;
    if (perspectiveXML == null)
        return;
    // backgrounded
    if (jEdit.getBufferCount() == 0)
        return;
    Buffer[] buffers = jEdit.getBuffers();
    Collection<Buffer> savedBuffers = new LinkedList<Buffer>();
    for (Buffer buffer : buffers) {
        if (!buffer.isNewFile() || buffer.isUntitled()) {
            savedBuffers.add(buffer);
        }
    }
    if (!autosave)
        Log.log(Log.MESSAGE, PerspectiveManager.class, "Saving " + perspectiveXML);
    String lineSep = System.getProperty("line.separator");
    SettingsXML.Saver out = null;
    try {
        out = perspectiveXML.openSaver();
        out.writeXMLDeclaration();
        out.write("<!DOCTYPE PERSPECTIVE SYSTEM \"perspective.dtd\">");
        out.write(lineSep);
        out.write("<PERSPECTIVE>");
        out.write(lineSep);
        for (Buffer buffer : savedBuffers) {
            out.write("<BUFFER AUTORELOAD=\"");
            out.write(buffer.getAutoReload() ? "TRUE" : "FALSE");
            out.write("\" AUTORELOAD_DIALOG=\"");
            out.write(buffer.getAutoReloadDialog() ? "TRUE" : "FALSE");
            out.write("\" UNTITLED=\"");
            out.write(buffer.isUntitled() ? "TRUE" : "FALSE");
            out.write("\">");
            // for untitled, we only have the autosave file
            out.write(XMLUtilities.charsToEntities(buffer.getPath(), false));
            out.write("</BUFFER>");
            out.write(lineSep);
        }
        View[] views = jEdit.getViews();
        for (int i = 0; i < views.length; i++) {
            View view = views[i];
            // on next load
            if (view == jEdit.getActiveView() && i != views.length - 1) {
                View last = views[views.length - 1];
                views[i] = last;
                views[views.length - 1] = view;
                view = last;
            }
            View.ViewConfig config = views[i].getViewConfig();
            out.write("<VIEW PLAIN=\"");
            out.write(config.plainView ? "TRUE" : "FALSE");
            out.write("\">");
            out.write(lineSep);
            if (config.title != null) {
                out.write(lineSep);
                out.write("<TITLE>");
                out.write(XMLUtilities.charsToEntities(config.title, false));
                out.write("</TITLE>");
                out.write(lineSep);
            }
            out.write("<PANES>");
            out.write(lineSep);
            out.write(XMLUtilities.charsToEntities(config.splitConfig, false));
            out.write(lineSep);
            out.write("</PANES>");
            out.write(lineSep);
            out.write("<GEOMETRY X=\"");
            out.write(String.valueOf(config.x));
            out.write("\" Y=\"");
            out.write(String.valueOf(config.y));
            out.write("\" WIDTH=\"");
            out.write(String.valueOf(config.width));
            out.write("\" HEIGHT=\"");
            out.write(String.valueOf(config.height));
            out.write("\" EXT_STATE=\"");
            out.write(String.valueOf(config.extState));
            out.write("\" />");
            out.write(lineSep);
            if (config.docking != null)
                config.docking.saveLayout(PERSPECTIVE_FILENAME, i);
            out.write("</VIEW>");
            out.write(lineSep);
        }
        out.write("</PERSPECTIVE>");
        out.write(lineSep);
        out.finish();
    } catch (IOException io) {
        Log.log(Log.ERROR, PerspectiveManager.class, "Error saving " + perspectiveXML);
        Log.log(Log.ERROR, PerspectiveManager.class, io);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}