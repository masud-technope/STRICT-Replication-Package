//}}}
//{{{ getRootDirectory() method
public static String getRootDirectory() {
    if (OperatingSystem.isMacOS() || OperatingSystem.isWindows())
        return FileRootsVFS.PROTOCOL + ':';
    else
        return "/";
}