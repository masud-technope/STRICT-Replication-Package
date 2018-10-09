//}}}
//{{{ getPluginJARs() method
/**
	 * Returns an array of installed plugins.
	 * @since jEdit 4.2pre1
	 */
public static PluginJAR[] getPluginJARs() {
    PluginJAR[] array = new PluginJAR[jars.size()];
    jars.copyInto(array);
    return array;
}