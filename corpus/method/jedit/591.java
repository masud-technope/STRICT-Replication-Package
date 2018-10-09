//}}}
//{{{ setModeAbbrevs() method
/**
	 * Sets the mode-specific abbreviation set.
	 * @param modes The new mode abbrev set
	 * @since jEdit 2.3pre1
	 */
public static void setModeAbbrevs(Hashtable<String, Hashtable<String, String>> modes) {
    abbrevsChanged = true;
    Abbrevs.modes = modes;
}