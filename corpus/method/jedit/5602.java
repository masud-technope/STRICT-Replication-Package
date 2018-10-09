// }}}
//{{{ parseJarsFilesString(String path, String jarsString) method
/**
	 * parse the files listed in plugin.CLASSNAME.jars or plugin.CLASSNAME.files
	 * and return full paths to each file of the list.
	 * @since jEdit 5.3pre1
	 */
public static Collection<String> parseJarsFilesString(String path, String jarsString) {
    String dir = MiscUtilities.getParentOfPath(path);
    StringTokenizer st = new StringTokenizer(jarsString);
    Collection<String> jarPaths = new LinkedList<String>();
    while (st.hasMoreTokens()) {
        String _jarPath = MiscUtilities.constructPath(dir, st.nextToken());
        jarPaths.add(_jarPath);
    }
    return jarPaths;
}