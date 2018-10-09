//}}}
//{{{ Property methods
//{{{ getCurrentLanguage() method
/**
	 * Returns the current language used by jEdit.
	 *
	 * @return the current language, never null
	 * @since jEdit 5.0pre1
	 */
public static String getCurrentLanguage() {
    String language;
    if (getBooleanProperty("lang.usedefaultlocale")) {
        language = Locale.getDefault().getLanguage();
    } else {
        language = getProperty("lang.current", "en");
    }
    return language;
}