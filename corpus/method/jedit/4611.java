//}}}
//{{{ getParentOfPath() method
@Override
public String getParentOfPath(String path) {
    if (OperatingSystem.isWindows()) {
        if (path.length() == 2 && path.charAt(1) == ':')
            return FileRootsVFS.PROTOCOL + ':';
        else if (path.length() == 3 && path.endsWith(":\\"))
            return FileRootsVFS.PROTOCOL + ':';
        else if (path.startsWith("\\\\") && path.indexOf('\\', 2) == -1)
            return path;
    }
    return super.getParentOfPath(path);
}