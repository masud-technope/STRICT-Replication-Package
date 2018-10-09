//}}}
/* //{{{ HelpIndex constructor
	public HelpIndex(String fileListPath, String wordIndexPath)
	{
		this();
	} //}}} */
//{{{ indexEditorHelp() method
/**
	 * Indexes all available help, including the jEdit user's guide, FAQ,]
	 * and plugin documentation.
	 */
public void indexEditorHelp() {
    try {
        String jEditHome = jEdit.getJEditHome();
        if (jEditHome != null) {
            indexDirectory(MiscUtilities.constructPath(jEditHome, "doc", "users-guide"));
            indexDirectory(MiscUtilities.constructPath(jEditHome, "doc", "FAQ"));
            indexDirectory(MiscUtilities.constructPath(jEditHome, "doc", "whatsnew"));
        }
    } catch (Throwable e) {
        Log.log(Log.ERROR, this, "Error indexing editor help");
        Log.log(Log.ERROR, this, e);
    }
    PluginJAR[] jars = jEdit.getPluginJARs();
    for (PluginJAR jar : jars) {
        try {
            indexJAR(jar.getZipFile());
        } catch (Throwable e) {
            Log.log(Log.ERROR, this, "Error indexing JAR: " + jar.getPath());
            Log.log(Log.ERROR, this, e);
        }
    }
    Log.log(Log.DEBUG, this, "Indexed " + words.size() + " words");
}