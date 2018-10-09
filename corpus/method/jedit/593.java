//}}}
//{{{ setGlobalAbbrevs() method
/**
	 * Sets the global abbreviation set.
	 * @param globalAbbrevs The new global abbrev set
	 * @since jEdit 2.3pre1
	 */
public static void setGlobalAbbrevs(Hashtable<String, String> globalAbbrevs) {
    abbrevsChanged = true;
    Abbrevs.globalAbbrevs = globalAbbrevs;
}