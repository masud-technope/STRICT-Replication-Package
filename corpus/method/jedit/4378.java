//}}}
//{{{ createTOC() method
/**
	 * Load the table of contents.
	 * Performs synchronous IO, so you don't want to call it from the GUI thread.
	 * @return the TOC tree model as a {@link DefaultMutableTreeNode}.
	 *         User objects are {@link HelpNode} instances.
	 */
public DefaultMutableTreeNode createTOC() {
    EditPlugin[] plugins = jEdit.getPlugins();
    Arrays.sort(plugins, new PluginCompare());
    DefaultMutableTreeNode tocRoot = new DefaultMutableTreeNode();
    tocRoot.add(createNode("welcome.html", jEdit.getProperty("helpviewer.toc.welcome")));
    tocRoot.add(createNode("README.txt", jEdit.getProperty("helpviewer.toc.readme")));
    tocRoot.add(createNode("CHANGES.txt", jEdit.getProperty("helpviewer.toc.changes")));
    tocRoot.add(createNode("TODO.txt", jEdit.getProperty("helpviewer.toc.todo")));
    tocRoot.add(createNode("COPYING.txt", jEdit.getProperty("helpviewer.toc.copying")));
    tocRoot.add(createNode("COPYING.DOC.txt", jEdit.getProperty("helpviewer.toc.copying-doc")));
    tocRoot.add(createNode("Apache.LICENSE.txt", jEdit.getProperty("helpviewer.toc.copying-apache")));
    tocRoot.add(createNode("COPYING.PLUGINS.txt", jEdit.getProperty("helpviewer.toc.copying-plugins")));
    loadTOC(tocRoot, "whatsnew/toc.xml");
    loadTOC(tocRoot, "users-guide/toc.xml");
    loadTOC(tocRoot, "FAQ/toc.xml");
    DefaultMutableTreeNode pluginTree = new DefaultMutableTreeNode(jEdit.getProperty("helpviewer.toc.plugins"), true);
    for (EditPlugin plugin : plugins) {
        String name = plugin.getClassName();
        String docs = jEdit.getProperty("plugin." + name + ".docs");
        String label = jEdit.getProperty("plugin." + name + ".name");
        if (label != null && docs != null) {
            String path = plugin.getPluginJAR().getClassLoader().getResourceAsPath(docs);
            pluginTree.add(createNode(path, label));
        }
    }
    if (pluginTree.getChildCount() != 0) {
        tocRoot.add(pluginTree);
    }
    loadTOC(tocRoot, "api/toc.xml");
    return tocRoot;
}