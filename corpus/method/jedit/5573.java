//}}}
//{{{ getDependencySet() method
/**
	 *
	 * @param className of a plugin that we wish to load
	 * @return an ordered set of JARpaths that contains the
	 *      plugins that need to be (re)loaded, in the correct order.
	 */
public static Set<String> getDependencySet(String className) {
    Set<String> retval = new LinkedHashSet<String>();
    PluginDepends[] deps = getPluginDepends(className);
    for (PluginDepends pluginDepends : deps) {
        if (pluginDepends.optional) {
            continue;
        }
        if ("plugin".equals(pluginDepends.what)) {
            int index2 = pluginDepends.arg.indexOf(' ');
            if (index2 == -1) {
                Log.log(Log.ERROR, PluginJAR.class, className + " has an invalid dependency: " + pluginDepends.dep + " (version is missing)");
                continue;
            }
            String pluginName = pluginDepends.arg.substring(0, index2);
            String needVersion = pluginDepends.arg.substring(index2 + 1);
            //todo : check version ?
            Set<String> loadTheseFirst = getDependencySet(pluginName);
            loadTheseFirst.add(pluginName);
            loadTheseFirst.addAll(retval);
            retval = loadTheseFirst;
        }
    }
    return retval;
}