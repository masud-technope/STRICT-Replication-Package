//}}}
//{{{ transitiveClosure()
/**
	 * If plugin A is needed by B, and B is needed by C, we want to
	 * tell the user that A is needed by B and C when they try to
	 * unload A.
	 *
	 * @param dependents a set of plugins which we wish to disable
	 * @param listModel a set of plugins which will be affected, and will need
	 *  to be disabled also.
	 */
public static void transitiveClosure(String[] dependents, List<String> listModel) {
    for (String jarPath : dependents) {
        if (!listModel.contains(jarPath)) {
            listModel.add(jarPath);
            PluginJAR jar = jEdit.getPluginJAR(jarPath);
            if (jar == null) {
                Log.log(Log.WARNING, PluginJAR.class, "The jar file " + jarPath + " doesn't exist, the plugin may have been partially removed");
            } else {
                transitiveClosure(jar.getDependentPlugins(), listModel);
            }
        }
    }
}