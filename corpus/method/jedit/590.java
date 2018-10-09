//}}}
//{{{ addModeAbbrev() method
/**
	 * Adds a mode-specific abbrev.
	 * @param mode The edit mode
	 * @param abbrev The abbrev
	 * @param expansion The expansion
	 * @since jEdit 3.1pre1
	 */
public static void addModeAbbrev(String mode, String abbrev, String expansion) {
    if (!loaded)
        load();
    Hashtable<String, String> modeAbbrevs = modes.get(mode);
    if (modeAbbrevs == null) {
        modeAbbrevs = new Hashtable<String, String>();
        modes.put(mode, modeAbbrevs);
    }
    modeAbbrevs.put(abbrev, expansion);
    abbrevsChanged = true;
}