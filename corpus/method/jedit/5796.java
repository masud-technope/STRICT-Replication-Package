//}}}
//{{{ endElement() method
public void endElement(String uri, String localName, String tag) {
    popElement();
    if (tag.equals("PLUGIN_SET")) {
        pluginList.addPluginSet(pluginSet);
        pluginSet = null;
        pluginSetEntry.setLength(0);
    } else if (tag.equals("PLUGIN_SET_ENTRY")) {
        pluginSet.plugins.add(pluginSetEntry.toString());
        pluginSetEntry.setLength(0);
    } else if (tag.equals("PLUGIN")) {
        plugin.jar = jar;
        plugin.name = name;
        plugin.author = author.toString();
        plugin.description = description.toString();
        pluginList.addPlugin(plugin);
        jar = null;
        name = null;
        author.setLength(0);
        description.setLength(0);
    } else if (tag.equals("BRANCH")) {
        branch.version = version;
        branch.date = date;
        branch.download = download.toString();
        branch.downloadSize = downloadSize;
        branch.downloadSource = downloadSource.toString();
        branch.downloadSourceSize = downloadSourceSize;
        branch.obsolete = obsolete;
        plugin.branches.add(branch);
        version = null;
        download.setLength(0);
        downloadSource.setLength(0);
        obsolete = false;
    } else if (tag.equals("DEPEND")) {
        PluginList.Dependency dep = new PluginList.Dependency(depWhat, depFrom, depTo, depPlugin);
        branch.deps.add(dep);
        depWhat = null;
        depFrom = null;
        depTo = null;
        depPlugin = null;
    }
}