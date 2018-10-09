//}}}
//{{{ getModeAbbrevs() method
/**
	 * @return the mode-specific abbreviation set.
	 * @since jEdit 2.3pre1
	 */
public static Hashtable<String, Hashtable<String, String>> getModeAbbrevs() {
    if (!loaded)
        load();
    return modes;
}