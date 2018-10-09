//}}}
//{{{ getPlugins() method
/**
	 * Returns an array of installed plugins.
	 */
public static EditPlugin[] getPlugins() {
    Collection<EditPlugin> pluginList = new ArrayList<EditPlugin>();
    for (int i = 0; i < jars.size(); i++) {
        EditPlugin plugin = jars.elementAt(i).getPlugin();
        if (plugin != null)
            pluginList.add(plugin);
    }
    EditPlugin[] array = new EditPlugin[pluginList.size()];
    pluginList.toArray(array);
    return array;
}