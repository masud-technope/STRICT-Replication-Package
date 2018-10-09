//}}}
//{{{ getPluginJAR() method
/**
	 * Returns the JAR with the specified path name.
	 * @param path The path name
	 * @since jEdit 4.2pre1
	 */
public static PluginJAR getPluginJAR(String path) {
    for (int i = 0; i < jars.size(); i++) {
        PluginJAR jar = jars.elementAt(i);
        if (jar.getPath().equals(path))
            return jar;
    }
    return null;
}