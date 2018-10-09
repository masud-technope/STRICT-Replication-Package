private String bundlePath(File bundleFile) {
    String rootPath = bundleDir.getAbsolutePath();
    String thisPath = bundleFile.getAbsolutePath();
    return thisPath.substring(rootPath.length());
}