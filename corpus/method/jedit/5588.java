//}}}
//{{{ getAllDependentPlugins() method
/**
	* @return an array of plugin names that have a dependency or an optional dependency on this plugin,
	* this returns a combination of <code>getDependentPlugins</code> and <code>getOptionallyDependentPlugins</code>.
	*/
public String[] getAllDependentPlugins() {
    String[] dependents = new String[theseRequireMe.size() + theseUseMe.size()];
    System.arraycopy(theseRequireMe.toArray(), 0, dependents, 0, theseRequireMe.size());
    System.arraycopy(theseUseMe.toArray(), 0, dependents, theseRequireMe.size(), theseUseMe.size());
    return dependents;
}