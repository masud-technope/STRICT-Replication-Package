//}}}
//{{{ getPathStart() method
private static int getPathStart(String path) {
    if (path.startsWith("/"))
        return 0;
    else if (OperatingSystem.isWindows() && path.length() >= 3 && path.charAt(1) == ':' && (path.charAt(2) == '/' || path.charAt(2) == '\\'))
        return 3;
    else
        return 0;
}