// }}}
//{{{ parseJarsFilesStringNames(String path, String jarsString) method
/**
	 * parse the files listed in plugin.CLASSNAME.jars or plugin.CLASSNAME.files
	 * and return them as a collection
	 * @since jEdit 5.3pre1
	 */
public static Collection<String> parseJarsFilesStringNames(String jarsString) {
    StringTokenizer st = new StringTokenizer(jarsString);
    Collection<String> jarPaths = new LinkedList<String>();
    while (st.hasMoreTokens()) {
        jarPaths.add(st.nextToken());
    }
    return jarPaths;
}