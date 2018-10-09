//}}}
//{{{ getBuild() method
/**
	 * Returns the internal version. MiscUtilities.compareStrings() can be used
	 * to compare different internal versions.
	 */
public static String getBuild() {
    // (major).(minor).(<99 = preX, 99 = "final").(bug fix)
    return "05.06.00.01";
}