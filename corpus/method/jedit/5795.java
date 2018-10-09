//}}}
//{{{ startElement() method
public void startElement(String uri, String localName, String tag, Attributes attrs) {
    for (int i = 0; i < attrs.getLength(); i++) {
        String aName = attrs.getQName(i);
        String aValue = attrs.getValue(i);
        attribute(aName, aValue, true);
    }
    tag = pushElement(tag);
    if (tag.equals("PLUGIN_SET")) {
        description.setLength(0);
        pluginSet = new PluginList.PluginSet();
        pluginSet.name = name;
    } else if (tag.equals("PLUGIN")) {
        description.setLength(0);
        author.setLength(0);
        branch = null;
        plugin = new PluginList.Plugin();
    } else if (tag.equals("BRANCH")) {
        download.setLength(0);
        branch = new PluginList.Branch();
    } else if (tag.equals("DOWNLOAD"))
        downloadSize = size;
    else if (tag.equals("DOWNLOAD_SOURCE"))
        downloadSourceSize = size;
}