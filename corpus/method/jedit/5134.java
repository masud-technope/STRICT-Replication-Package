//{{{ Path name methods
//{{{ canonPath() method
/**
	 * @return the canonical form of the specified path name. Currently
	 * only expands a leading <code>~</code>. <b>For local path names
	 * only.</b>
	 * @param path The path name
	 * @since jEdit 4.0pre2
	 */
public static String canonPath(String path) {
    if (path.length() == 0)
        return path;
    if (path.startsWith("file://"))
        path = path.substring("file://".length());
    else if (path.startsWith("file:"))
        path = path.substring("file:".length());
    else if (isURL(path))
        return path;
    if (File.separatorChar == '\\') {
        path = path.replace('/', '\\');
        int trim = path.length();
        while (path.charAt(trim - 1) == ' ') trim--;
        if (path.charAt(trim - 1) == '\\')
            while (trim > 1 && path.charAt(trim - 2) == '\\') {
                trim--;
            }
        path = path.substring(0, trim);
    }
    if (path.startsWith('~' + File.separator)) {
        path = path.substring(2);
        String home = System.getProperty("user.home");
        if (home.endsWith(File.separator))
            return home + path;
        else
            return home + File.separator + path;
    } else if ("~".equals(path))
        return System.getProperty("user.home");
    else if ("-".equals(path))
        return getParentOfPath(jEdit.getActiveView().getBuffer().getPath());
    else
        return path;
}