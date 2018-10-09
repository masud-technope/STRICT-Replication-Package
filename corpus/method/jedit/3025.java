//}}}
//{{{ handleClient() method
/**
	 * @param restore Ignored unless no views are open
	 * @param newView Open a new view?
	 * @param newPlainView Open a new plain view?
	 * @param parent The client's parent directory
	 * @param args A list of files. Null entries are ignored, for convenience
	 * @return the buffer
	 * @since jEdit 4.2pre1
	 */
public static Buffer handleClient(boolean restore, boolean newView, boolean newPlainView, String parent, String[] args) {
    // we have to deal with a huge range of possible border cases here.
    if (jEdit.getFirstView() == null) {
        // coming out of background mode.
        // no views open.
        // no buffers open if args empty.
        boolean hasBufferArgs = false;
        for (String arg : args) {
            if (arg != null) {
                hasBufferArgs = true;
                break;
            }
        }
        boolean restoreFiles = restore && jEdit.getBooleanProperty("restore") && (!hasBufferArgs || jEdit.getBooleanProperty("restore.cli"));
        View view = PerspectiveManager.loadPerspective(restoreFiles);
        Buffer buffer = jEdit.openFiles(view, parent, args);
        if (view == null) {
            if (buffer == null)
                buffer = jEdit.getFirstBuffer();
            jEdit.newView(null, buffer);
        } else if (buffer != null)
            view.setBuffer(buffer);
        return buffer;
    } else if (newPlainView) {
        // no background mode, and opening a new view
        Buffer buffer = jEdit.openFiles(null, parent, args);
        if (buffer == null)
            buffer = jEdit.getFirstBuffer();
        jEdit.newView(null, buffer, true);
        return buffer;
    } else if (newView) {
        // no background mode, and opening a new view
        Buffer buffer = jEdit.openFiles(null, parent, args);
        if (buffer == null)
            buffer = jEdit.getFirstBuffer();
        jEdit.newView(jEdit.getActiveView(), buffer, false);
        return buffer;
    } else {
        // no background mode, and reusing existing view
        View view = jEdit.getActiveView();
        Buffer buffer = jEdit.openFiles(view, parent, args);
        // OSes too.
        if (jEdit.getBooleanProperty("server.brokenToFront"))
            view.setState(java.awt.Frame.ICONIFIED);
        // un-iconify using JDK 1.3 API
        view.setState(java.awt.Frame.NORMAL);
        view.requestFocus();
        view.toFront();
        // In some platforms (e.g. Windows), only setAlwaysOnTop works
        if (!view.isAlwaysOnTop()) {
            view.setAlwaysOnTop(true);
            view.setAlwaysOnTop(false);
        }
        return buffer;
    }
}