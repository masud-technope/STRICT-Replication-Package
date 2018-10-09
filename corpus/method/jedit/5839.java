//{{{ runInAWTThread() method
public void runInAWTThread(Component comp) {
    // close JAR file and all JARs that depend on this
    PluginJAR jar = jEdit.getPluginJAR(this.jar);
    if (jar != null) {
        unloadPluginJAR(jar);
    }
    toLoad.remove(this.jar);
    File jarFile = new File(this.jar);
    File srcFile = new File(this.jar.substring(0, this.jar.length() - 4));
    if (jarFile.exists()) {
        Log.log(Log.NOTICE, this, "Deleting " + jarFile);
        boolean ok = jarFile.delete();
        if (ok) {
            EditBus.send(new PluginUpdate(jarFile, PluginUpdate.REMOVED, false));
        }
        if (srcFile.exists()) {
            ok &= recursiveDelete(srcFile);
        }
        if (!ok) {
            String[] args = { this.jar };
            GUIUtilities.error(comp, "plugin-manager.remove-failed", args);
        }
    }
//}}}
}