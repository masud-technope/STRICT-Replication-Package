//}}}
//{{{ addGlobalAbbrev() method
/**
	 * Adds an abbreviation to the global abbreviation list.
	 * @param abbrev The abbreviation
	 * @param expansion The expansion
	 * @since jEdit 3.1pre1
	 */
public static void addGlobalAbbrev(String abbrev, String expansion) {
    if (!loaded)
        load();
    globalAbbrevs.put(abbrev, expansion);
    abbrevsChanged = true;
}