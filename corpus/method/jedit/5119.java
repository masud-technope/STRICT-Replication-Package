public static String getFileName(String path) {
    return VFSManager.getVFSForPath(path).getFileName(path);
}