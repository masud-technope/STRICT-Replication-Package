//}}}
//{{{ getDependentPlugins() method
/**
	* @return an array of plugin names that have a hard dependency on this plugin
	*/
public String[] getDependentPlugins() {
    return theseRequireMe.toArray(new String[theseRequireMe.size()]);
}