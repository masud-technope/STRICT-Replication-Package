//}}}
//{{{ connect()
/**
	 * @throws	IOException	on error
	 * @throws	FileNotFoundException if resource is not found
	 */
public void connect() throws IOException, FileNotFoundException {
    if (!connected) {
        if (plugin == null) {
            in = jEdit.class.getResourceAsStream(resource);
        } else {
            boolean pluginFoundInPluginJARs = false;
            PluginJAR[] plugins = jEdit.getPluginJARs();
            for (PluginJAR jar : plugins) {
                String jarName = MiscUtilities.getFileName(jar.getPath()).toLowerCase();
                if (plugin.equalsIgnoreCase(jarName)) {
                    pluginFoundInPluginJARs = true;
                    in = jar.getClassLoader().getResourceAsStream(resource);
                    break;
                }
            }
            if (!pluginFoundInPluginJARs) {
                Log.log(Log.DEBUG, PluginResURLConnection.class, "reading resource from not loaded plugin " + " => will always fail !");
            }
        }
        if ((in == null) && (plugin == null)) {
            // can't find it in jEdit.jar, look in getJEditHome().
            File f = new File(jEdit.getJEditHome(), resource);
            if (f.exists())
                in = new FileInputStream(f);
        }
        connected = true;
    }
    if (in == null) {
        if (plugin != null) {
            throw new FileNotFoundException("Resource not found: " + plugin + "!" + resource);
        } else {
            throw new FileNotFoundException("Resource not found: " + getURL());
        }
    }
}