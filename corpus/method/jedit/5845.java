//}}}
//{{{ getDownloadDir() method
private static String getDownloadDir() {
    if (downloadDir == null) {
        String settings = jEdit.getSettingsDirectory();
        if (settings == null)
            settings = System.getProperty("user.home");
        downloadDir = new File(MiscUtilities.constructPath(settings, "PluginManager.download"));
        downloadDir.mkdirs();
    }
    return downloadDir.getPath();
}