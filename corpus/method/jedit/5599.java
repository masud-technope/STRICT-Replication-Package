/**
	 * Creates a PluginJAR object which is not necessarily loaded, but can be later.
	 * @see #load(String, boolean)
	 */
public  PluginJAR(File file) {
    path = file.getPath();
    String jarCacheDir = jEdit.getJARCacheDirectory();
    if (jarCacheDir != null) {
        cachePath = MiscUtilities.constructPath(jarCacheDir, file.getName() + ".summary");
    }
    this.file = file;
    classLoader = new JARClassLoader(this);
    actions = new ActionSet();
}