public static String getParentOfPath(String path) {
    return VFSManager.getVFSForPath(path).getParentOfPath(path);
}