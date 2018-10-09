public static String constructPath(String parent, String path) {
    if (isAbsolutePath(path))
        return canonPath(path);
    if (parent == null)
        parent = System.getProperty("user.dir");
    if (path == null || path.length() == 0)
        return parent;
    if (OperatingSystem.isWindows()) {
        if (path.length() == 2 && path.charAt(1) == ':')
            return path;
        else if (path.length() > 2 && path.charAt(1) == ':' && path.charAt(2) != '\\') {
            path = path.substring(0, 2) + '\\' + path.substring(2);
            return canonPath(path);
        }
    }
    String dd = ".." + File.separator;
    String d = '.' + File.separator;
    for (; ; ) {
        if (".".equals(path))
            return parent;
        else if ("..".equals(path))
            return getParentOfPath(parent);
        else if (path.startsWith(dd) || path.startsWith("../")) {
            parent = getParentOfPath(parent);
            path = path.substring(3);
        } else if (path.startsWith(d) || path.startsWith("./"))
            path = path.substring(2);
        else
            break;
    }
    if (path.length() == 0)
        return parent;
    if (OperatingSystem.isWindows() && !isURL(parent) && path.charAt(0) == '\\')
        parent = parent.substring(0, 2);
    VFS vfs = VFSManager.getVFSForPath(parent);
    return canonPath(vfs.constructPath(parent, path));
}