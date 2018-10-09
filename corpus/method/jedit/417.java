public String getDefaultDirectory(Install installer) {
    String dir = "/usr/local/";
    if (!new File(dir).canWrite()) {
        dir = System.getProperty("user.home");
    }
    return new File(dir, "bin").getPath();
}