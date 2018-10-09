//}}}
//{{{ checkDependencies() method
/**
	 * Returns true if all dependencies are satisified, false otherwise.
	 * Also if dependencies are not satisfied, the plugin is marked as
	 * "broken".
	 *
	 */
public boolean checkDependencies() {
    if (plugin == null)
        return true;
    boolean ok = true;
    String name = plugin.getClassName();
    PluginDepends[] deps = getPluginDepends(name);
    for (PluginDepends pluginDepends : deps) {
        if ("jdk".equals(pluginDepends.what)) {
            if (!pluginDepends.optional && StandardUtilities.compareStrings(System.getProperty("java.version"), pluginDepends.arg, false) < 0) {
                String[] args = { pluginDepends.arg, System.getProperty("java.version") };
                jEdit.pluginError(path, "plugin-error.dep-jdk", args);
                ok = false;
            }
        } else if ("jedit".equals(pluginDepends.what)) {
            if (pluginDepends.arg.length() != 11) {
                Log.log(Log.ERROR, this, "Invalid jEdit version" + " number: " + pluginDepends.arg);
                ok = false;
            }
            if (!pluginDepends.optional && StandardUtilities.compareStrings(jEdit.getBuild(), pluginDepends.arg, false) < 0) {
                String needs = MiscUtilities.buildToVersion(pluginDepends.arg);
                String[] args = { needs, jEdit.getVersion() };
                jEdit.pluginError(path, "plugin-error.dep-jedit", args);
                ok = false;
            }
        } else if ("plugin".equals(pluginDepends.what)) {
            int index2 = pluginDepends.arg.indexOf(' ');
            if (index2 == -1) {
                Log.log(Log.ERROR, this, name + " has an invalid dependency: " + pluginDepends.dep + " (version is missing)");
                ok = false;
                continue;
            }
            String pluginName = pluginDepends.arg.substring(0, index2);
            String needVersion = pluginDepends.arg.substring(index2 + 1);
            String currVersion = jEdit.getProperty("plugin." + pluginName + ".version");
            EditPlugin editPlugin = jEdit.getPlugin(pluginName, false);
            if (editPlugin == null) {
                if (!pluginDepends.optional) {
                    String[] args = { needVersion, pluginName };
                    jEdit.pluginError(path, "plugin-error.dep-plugin.no-version", args);
                    ok = false;
                }
            } else if (StandardUtilities.compareStrings(currVersion, needVersion, false) < 0) {
                if (!pluginDepends.optional) {
                    String[] args = { needVersion, pluginName, currVersion };
                    jEdit.pluginError(path, "plugin-error.dep-plugin", args);
                    ok = false;
                }
            } else if (editPlugin instanceof EditPlugin.Broken) {
                if (!pluginDepends.optional) {
                    String[] args = { pluginName };
                    jEdit.pluginError(path, "plugin-error.dep-plugin.broken", args);
                    ok = false;
                }
            } else {
                PluginJAR jar = editPlugin.getPluginJAR();
                if (pluginDepends.optional) {
                    jar.theseUseMe.add(path);
                    weUseThese.add(jar.getPath());
                } else {
                    jar.theseRequireMe.add(path);
                    weRequireThese.add(jar.getPath());
                }
            }
        } else if ("class".equals(pluginDepends.what)) {
            if (!pluginDepends.optional) {
                try {
                    classLoader.loadClass(pluginDepends.arg, false);
                } catch (Exception e) {
                    String[] args = { pluginDepends.arg };
                    jEdit.pluginError(path, "plugin-error.dep-class", args);
                    ok = false;
                }
            }
        } else {
            Log.log(Log.ERROR, this, name + " has unknown" + " dependency: " + pluginDepends.dep);
            ok = false;
        }
    }
    // each JAR file listed in the plugin's jars property
    // needs to know that we need them
    Collection<String> jarsPaths = getJars();
    for (String jarPath : jarsPaths) {
        PluginJAR jar = jEdit.getPluginJAR(jarPath);
        if (jar == null) {
            String[] args = { jarPath };
            jEdit.pluginError(path, "plugin-error.missing-jar", args);
            ok = false;
        } else {
            weRequireThese.add(jarPath);
            jar.theseRequireMe.add(path);
        }
    }
    if (!ok)
        breakPlugin();
    return ok;
}