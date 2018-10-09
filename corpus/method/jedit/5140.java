public static boolean isAbsolutePath(String path) {
    if (isURL(path))
        return true;
    else if (path.startsWith("~/") || path.startsWith('~' + File.separator) || "~".equals(path))
        return true;
    else if ("-".equals(path))
        return true;
    else if (OperatingSystem.isWindows()) {
        if (path.length() == 2 && path.charAt(1) == ':')
            return true;
        if (path.length() > 2 && path.charAt(1) == ':' && (path.charAt(2) == '\\' || path.charAt(2) == '/'))
            return true;
        if (path.startsWith("\\\\") || path.startsWith("//"))
            return true;
    } else if (OperatingSystem.isUnix() || OperatingSystem.isVMS()) {
        if (path.length() > 0 && path.charAt(0) == '/')
            return true;
    }
    return false;
}