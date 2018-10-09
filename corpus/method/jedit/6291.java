//}}}
//{{{ load() method
/**
	 * Loads search and replace state from the properties.
	 */
public static void load() {
    search = jEdit.getProperty("search.find.value");
    replace = jEdit.getProperty("search.replace.value");
    wholeWord = jEdit.getBooleanProperty("search.wholeWord.toggle");
    ignoreCase = jEdit.getBooleanProperty("search.ignoreCase.toggle");
    regexp = jEdit.getBooleanProperty("search.regexp.toggle");
    beanshell = jEdit.getBooleanProperty("search.beanshell.toggle");
    wrap = jEdit.getBooleanProperty("search.wrap.toggle");
    fileset = new CurrentBufferSet();
    // Tags plugin likes to call this method at times other than
    // startup; so we need to fire a SearchSettingsChanged to
    // notify the search bar and so on.
    matcher = null;
    EditBus.send(new SearchSettingsChanged(null));
}