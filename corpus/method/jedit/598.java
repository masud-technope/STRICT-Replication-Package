//}}}
//{{{ setExpandOnInput() method
/**
	 * Sets if abbreviations should be expanded after the
	 * user finishes typing a word.
	 * @param expandOnInput If true, typing a non-alphanumeric character
	 * will automatically attempt to expand the current abbrev
	 */
public static void setExpandOnInput(boolean expandOnInput) {
    Abbrevs.expandOnInput = expandOnInput;
}