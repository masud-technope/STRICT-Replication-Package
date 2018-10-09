/**
		 * Constructor used for loaded jars.
		 *
		 * @param jar the pluginJar
		 */
 Entry(PluginJAR jar) {
    jars = new LinkedList<String>();
    this.jar = jar.getPath();
    jars.add(this.jar);
    plugin = jar.getPlugin();
    if (plugin != null) {
        status = plugin instanceof EditPlugin.Broken ? ERROR : LOADED;
        clazz = plugin.getClassName();
        name = jEdit.getProperty("plugin." + clazz + ".name");
        version = jEdit.getProperty("plugin." + clazz + ".version");
        author = jEdit.getProperty("plugin." + clazz + ".author");
        docs = jEdit.getProperty("plugin." + clazz + ".docs");
        description = jEdit.getProperty("plugin." + clazz + ".description");
        jars.addAll(jar.getJars());
        jars.addAll(jar.getFiles());
    } else {
        status = LOADED;
    }
}