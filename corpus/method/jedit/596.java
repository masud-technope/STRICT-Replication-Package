//}}}
//{{{ getGlobalAbbrevs() method
/**
	 * @return the global abbreviation set.
	 * @since jEdit 2.3pre1
	 */
public static Hashtable<String, String> getGlobalAbbrevs() {
    if (!loaded)
        load();
    return globalAbbrevs;
}