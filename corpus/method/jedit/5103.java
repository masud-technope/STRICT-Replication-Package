//}}}
//{{{ getEncodings() methods
/**
	 * Returns a list of supported character encodings.
	 * @since jEdit 4.3
	 * @param getSelected Whether to return just the selected encodings or all.
	 */
public static String[] getEncodings(boolean getSelected) {
    Set<String> set;
    if (getSelected) {
        set = EncodingServer.getSelectedNames();
    } else {
        set = EncodingServer.getAvailableNames();
    }
    return set.toArray(new String[set.size()]);
}