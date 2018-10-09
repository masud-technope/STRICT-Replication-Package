//}}}
//{{{ getDependencies() method
/**
	 * Returns a list of dependencies by searching the plugin properties.
	 * @param classname The classname of a plugin
	 * @return A list of classnames of plugins the plugin depends on.
	 */
public static Set<String> getDependencies(String classname) throws IllegalArgumentException {
    Set<String> ret = new HashSet<String>();
    int i = 0;
    String dep;
    while ((dep = jEdit.getProperty("plugin." + classname + ".depend." + i++)) != null) {
        int index = dep.indexOf(' ');
        String what = dep.substring(0, index);
        String arg = dep.substring(index + 1);
        if ("plugin".equals(what)) {
            ret.add(arg.indexOf(' ') > 0 ? arg.substring(0, arg.indexOf(' ')) : arg);
        }
    }
    return ret;
}