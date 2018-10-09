//}}}
//{{{ runStartupScripts() method
/**
	 * Runs scripts in a directory.
	 */
private static void runStartupScripts(File directory) {
    if (!directory.isDirectory())
        return;
    File[] snippets = directory.listFiles();
    if (snippets == null)
        return;
    Arrays.sort(snippets, new StandardUtilities.StringCompare<File>(true));
    /*
		 * Force the default encoding to UTF-8 temporarily.
		 * The shipped scripts use that encoding, so we need
		 * to make sure we can load them correctly. If users
		 * want to write script with a different encoding,
		 * they can use buffer-local properties on the
		 * script to set it.
		 */
    String defaultEncoding = getProperty("buffer.encoding");
    setProperty("buffer.encoding", "UTF-8");
    for (File snippet : snippets) {
        Macros.Handler handler = Macros.getHandlerForPathName(snippet.getPath());
        if (handler == null)
            continue;
        try {
            Macros.Macro newMacro = handler.createMacro(snippet.getName(), snippet.getPath());
            handler.runMacro(null, newMacro, false);
        } catch (Exception e) {
            Log.log(Log.ERROR, jEdit.class, e);
        }
    }
    setProperty("buffer.encoding", defaultEncoding);
}