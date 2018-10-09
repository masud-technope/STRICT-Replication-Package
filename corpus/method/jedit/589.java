//{{{ load() method
private static void load() {
    globalAbbrevs = new Hashtable<String, String>();
    modes = new Hashtable<String, Hashtable<String, String>>();
    String settings = jEdit.getSettingsDirectory();
    if (settings != null) {
        File file = new File(MiscUtilities.constructPath(settings, "abbrevs"));
        abbrevsModTime = file.lastModified();
        try {
            loadAbbrevs(new InputStreamReader(new FileInputStream(file), ENCODING));
            loaded = true;
        } catch (FileNotFoundException fnf) {
        } catch (Exception e) {
            Log.log(Log.ERROR, Abbrevs.class, "Error while loading " + file);
            Log.log(Log.ERROR, Abbrevs.class, e);
        }
    }
    // only load global abbrevs if user abbrevs file could not be loaded
    if (!loaded) {
        try {
            loadAbbrevs(new InputStreamReader(Abbrevs.class.getResourceAsStream("default.abbrevs"), ENCODING));
        } catch (Exception e) {
            Log.log(Log.ERROR, Abbrevs.class, "Error while loading default.abbrevs");
            Log.log(Log.ERROR, Abbrevs.class, e);
        }
        loaded = true;
    }
}