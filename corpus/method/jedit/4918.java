//}}}
//{{{ loadModeCatalog() method
/**
	 * Loads a mode catalog file.
	 * @since jEdit 3.2pre2
	 */
private static void loadModeCatalog(String path, boolean resource, final boolean userMode) {
    Log.log(Log.MESSAGE, jEdit.class, "Loading mode catalog file " + path);
    ModeCatalogHandler handler = new ModeCatalogHandler(MiscUtilities.getParentOfPath(path), resource) {

        @Override
        protected Mode instantiateMode(String modeName) {
            Mode mode = new JEditMode(modeName);
            mode.setUserMode(userMode);
            return mode;
        }
    };
    try {
        InputStream _in;
        if (resource)
            _in = jEdit.class.getResourceAsStream(path);
        else
            _in = new FileInputStream(path);
        XMLUtilities.parseXML(_in, handler);
    } catch (IOException e) {
        Log.log(Log.ERROR, jEdit.class, e);
    }
}