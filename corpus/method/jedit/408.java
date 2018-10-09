public String getInstallDirectory(String name, String version) {
    String dir = "/usr/local/share/";
    if (!new File(dir).canWrite()) {
        dir = System.getProperty("user.home");
    }
    return new File(dir, name + "/" + version).getPath();
}