//}}}
//{{{ save() method
/**
	 * Saves search and replace state to the properties.
	 */
public static void save() {
    jEdit.setProperty("search.find.value", search);
    jEdit.setProperty("search.replace.value", replace);
    jEdit.setBooleanProperty("search.wholeWord.toggle", wholeWord);
    jEdit.setBooleanProperty("search.ignoreCase.toggle", ignoreCase);
    jEdit.setBooleanProperty("search.regexp.toggle", regexp);
    jEdit.setBooleanProperty("search.beanshell.toggle", beanshell);
    jEdit.setBooleanProperty("search.wrap.toggle", wrap);
}