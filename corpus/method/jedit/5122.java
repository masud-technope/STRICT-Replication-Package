public static boolean isURL(String str) {
    int fsIndex = getLastSeparatorIndex(str);
    if (fsIndex == 0)
        return false;
    else if (fsIndex == 2)
        return false;
    int cIndex = str.indexOf(':');
    if (cIndex <= 1)
        return false;
    String protocol = str.substring(0, cIndex);
    VFS vfs = VFSManager.getVFSForProtocol(protocol);
    if (vfs != null && !(vfs instanceof UrlVFS))
        return true;
    try {
        new URL(str);
        return true;
    } catch (MalformedURLException mf) {
        return false;
    }
}