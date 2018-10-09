//}}}
//{{{ checkForObsoletePlugins()
/** Checks for obsolete plugins, and marks them as unsupported.
	 *  <p>
	 *  An obsolete plugin branch can be marked as inactive, or
	 *  an individual release can have a max jEdit version that is 
	 *  lower than the running version. If no later version/branch exists
	 *  that supports this jEdit version, the plugin is unsupported.
	 * @since jEdit 5.1pre1
	 * @author Alan Ezust
    */
public void checkForObsoletePlugins() {
    if ((pluginList == null) || (pluginList.plugins == null))
        return;
    // for each plugin that is installed:			
    for (PluginJAR jar : jEdit.getPluginJARs()) {
        EditPlugin eplugin = jar.getPlugin();
        if (eplugin == null)
            continue;
        String installedVersion = jEdit.getProperty("plugin." + eplugin.getClassName() + ".version");
        // find corresponding entry in pluginList:
        for (Plugin plugin : pluginList.plugins) if (MiscUtilities.pathsEqual(plugin.jar, MiscUtilities.getFileName(jar.getPath()))) {
            // find the branch with latest version greater than or equal to installedVersion
            Branch lastBranch = null;
            String latestVersion = "0";
            for (Branch branch : plugin.branches) if (StandardUtilities.compareStrings(branch.version, installedVersion, false) >= 0)
                if (StandardUtilities.compareStrings(branch.version, latestVersion, false) >= 0) {
                    latestVersion = branch.version;
                    lastBranch = branch;
                }
            if (lastBranch != null)
                if (lastBranch.obsolete)
                    disablePlugin(jar, plugin.name);
                else
                    for (Dependency dep : lastBranch.deps) // if there is a max jEdit version, check if we're higher:
                    if (dep.what.equals("jedit") && (dep.to != null))
                        if (StandardUtilities.compareStrings(jEdit.getBuild(), dep.to, false) > 0)
                            disablePlugin(jar, plugin.name);
        }
    }
}