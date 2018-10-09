public static String concatPath(String parent, String path) {
    parent = canonPath(parent);
    path = canonPath(path);
    if (path.startsWith(File.separator))
        path = path.substring(1);
    else if (path.length() >= 3 && path.charAt(1) == ':')
        path = path.replace(':', File.separatorChar);
    if (parent == null)
        parent = System.getProperty("user.dir");
    if (parent.endsWith(File.separator))
        return parent + path;
    else
        return parent + File.separator + path;
}