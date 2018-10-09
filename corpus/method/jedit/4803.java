//}}}
//{{{ getAllModes() method
/**
	 * Returns an array of all installed edit modes. The modes in this array
	 * will be sorted by mode name.
	 */
public static Mode[] getAllModes() {
    Mode[] modes = ModeProvider.instance.getModes();
    Arrays.sort(modes, new StandardUtilities.StringCompare<Mode>(true));
    return modes;
}