//}}}
//{{{ findPlugin() method
/**
	 * Unlike getPlugin(), will return a PluginJAR that is not yet loaded,
	 * given its classname.
	 *
	 * @param className a class name
	 * @return the JARpath of the first PluginJAR it can find which contains this className,
	 * 		    or null if not found.
	 * @since 4.3pre7
	 */
public static String findPlugin(String className) {
    EditPlugin ep = jEdit.getPlugin(className);
    if (ep != null)
        return ep.getPluginJAR().getPath();
    for (String JARpath : jEdit.getNotLoadedPluginJARs()) {
        PluginJAR pjar = new PluginJAR(new File(JARpath));
        if (pjar.containsClass(className)) {
            return JARpath;
        }
    }
    return null;
}