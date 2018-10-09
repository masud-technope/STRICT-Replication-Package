//}}}
//{{{ initUserProperties() method
/**
	 * Loads user properties.
	 */
private static void initUserProperties() {
    if (settingsDirectory != null) {
        File file = new File(MiscUtilities.constructPath(settingsDirectory, "properties"));
        propsModTime = file.lastModified();
        try {
            propMgr.loadUserProps(new FileInputStream(file));
        } catch (FileNotFoundException fnf) {
        } catch (Exception e) {
            Log.log(Log.ERROR, jEdit.class, e);
        }
    }
}