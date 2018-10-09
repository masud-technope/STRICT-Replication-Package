//}}}
//}}}
//{{{ Edit mode methods
//{{{ reloadModes() method
/**
	 * Reloads all edit modes.  User defined edit modes are loaded after
	 * global modes so that user modes supercede global modes.
	 * @since jEdit 3.2pre2
	 */
public static void reloadModes() {
    ModeProvider.instance.removeAll();
    //{{{ Load the global catalog first
    if (jEditHome == null)
        loadModeCatalog("/modes/catalog", true, false);
    else {
        loadModeCatalog(MiscUtilities.constructPath(jEditHome, "modes", "catalog"), false, false);
    //}}}
    }
    //{{{ Load user catalog second so user modes override global modes.
    if (settingsDirectory != null) {
        File userModeDir = new File(MiscUtilities.constructPath(settingsDirectory, "modes"));
        if (!userModeDir.exists())
            userModeDir.mkdirs();
        File userCatalog = new File(MiscUtilities.constructPath(settingsDirectory, "modes", "catalog"));
        if (!userCatalog.exists()) {
            // create dummy catalog
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userCatalog), "UTF-8"));
                out.write(jEdit.getProperty("defaultCatalog"));
            } catch (IOException io) {
                Log.log(Log.ERROR, jEdit.class, io);
            } finally {
                IOUtilities.closeQuietly((Closeable) out);
            }
        }
        loadModeCatalog(userCatalog.getPath(), false, true);
    //}}}
    }
    Buffer buffer = buffersFirst;
    while (buffer != null) {
        // This reloads the token marker and sends a message
        // which causes edit panes to repaint their text areas
        buffer.setMode();
        buffer = buffer.next;
    }
}