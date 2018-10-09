public static String resolveSymlinks(String path) {
    if (isURL(path))
        return path;
    if (OperatingSystem.isOS2())
        return path;
    if (OperatingSystem.isWindows()) {
        if (path.length() == 2 || path.length() == 3) {
            if (path.charAt(1) == ':')
                return path;
        }
    }
    try {
        return new File(path).getCanonicalPath();
    } catch (IOException io) {
        return path;
    }
}