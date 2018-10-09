//}}}
//{{{ initLocalizationProperties() method
/**
	 * Loads localization property file(s).
	 */
private static void initLocalizationProperties() {
    String language = getCurrentLanguage();
    if ("en".equals(language)) {
        // no need to load english as localization property as it always loaded as default language
        return;
    }
    Reader langResource = null;
    try {
        langResource = getResourceAsUTF8Text("/org/jedit/localization/jedit_" + language + ".props");
        propMgr.loadLocalizationProps(langResource);
    } catch (IOException e) {
        if (getBooleanProperty("lang.usedefaultlocale")) {
            Log.log(Log.ERROR, jEdit.class, "Unable to load language", e);
        }
    } finally {
        IOUtilities.closeQuietly((Closeable) langResource);
    }
}