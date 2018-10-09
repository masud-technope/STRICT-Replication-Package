//}}}
//{{{ cacheDockableWindows() method
/**
	 * @since jEdit 4.2pre1
	 */
public void cacheDockableWindows(PluginJAR plugin, String[] name, boolean[] actions, boolean[] movable) {
    for (int i = 0; i < name.length; i++) {
        Window factory = new Window(plugin, name[i], null, actions[i], movable[i]);
        dockableWindowFactories.put(name[i], factory);
    }
}