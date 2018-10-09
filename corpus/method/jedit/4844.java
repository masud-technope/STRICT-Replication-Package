//}}}
//{{{ initSiteProperties() method
/**
	 * Load site properties.
	 */
private static void initSiteProperties() {
    // site properties are loaded as default properties, overwriting
    // jEdit's system properties
    String siteSettingsDirectory = MiscUtilities.constructPath(jEditHome, "properties");
    File siteSettings = new File(siteSettingsDirectory);
    if (!(siteSettings.exists() && siteSettings.isDirectory()))
        return;
    String[] snippets = siteSettings.list();
    if (snippets == null)
        return;
    Arrays.sort(snippets, new StandardUtilities.StringCompare<String>(true));
    for (String snippet : snippets) {
        if (!snippet.toLowerCase().endsWith(".props"))
            continue;
        try {
            String path = MiscUtilities.constructPath(siteSettingsDirectory, snippet);
            Log.log(Log.DEBUG, jEdit.class, "Loading site snippet: " + path);
            propMgr.loadSiteProps(new FileInputStream(new File(path)));
        } catch (FileNotFoundException fnf) {
            Log.log(Log.DEBUG, jEdit.class, fnf);
        } catch (IOException e) {
            Log.log(Log.ERROR, jEdit.class, "Cannot load site snippet " + snippet);
            Log.log(Log.ERROR, jEdit.class, e);
        }
    }
}