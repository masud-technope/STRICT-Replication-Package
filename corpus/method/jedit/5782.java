String getInstalledPath() {
    if (installedPath != null) {
        if (new File(installedPath).exists()) {
            return installedPath;
        } else {
            installedPath = null;
        }
    }
    PluginJAR[] jars = jEdit.getPluginJARs();
    for (int i = 0; i < jars.length; i++) {
        String path = jars[i].getPath();
        if (MiscUtilities.getFileName(path).equals(jar))
            return path;
    }
    return null;
}