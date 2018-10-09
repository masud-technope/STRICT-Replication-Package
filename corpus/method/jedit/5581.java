//}}}
//{{{ getOptionallyDependentPlugins() method
/**
	* @return an array of plugin names that have an optional dependency on this plugin
	*/
public String[] getOptionallyDependentPlugins() {
    return theseUseMe.toArray(new String[theseUseMe.size()]);
}