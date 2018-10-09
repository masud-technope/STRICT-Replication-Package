//}}}
//{{{ pathsEqual() method
/**
	 * @param p1 A path name
	 * @param p2 A path name
	 * @return True if both paths are equal, ignoring trailing slashes, as
	 * well as case insensitivity on Windows.
	 * @since jEdit 4.3pre2
	 */
public static boolean pathsEqual(String p1, String p2) {
    VFS v1 = VFSManager.getVFSForPath(p1);
    VFS v2 = VFSManager.getVFSForPath(p2);
    if (v1 != v2)
        return false;
    if (p1.endsWith("/") || p1.endsWith(File.separator))
        p1 = p1.substring(0, p1.length() - 1);
    if (p2.endsWith("/") || p2.endsWith(File.separator))
        p2 = p2.substring(0, p2.length() - 1);
    if ((v1.getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0)
        return p1.equalsIgnoreCase(p2);
    else
        return p1.equals(p2);
}