@Override
public VFSFile _getFile(Object session, String path, Component comp) {
    if (path.equals("/") && OperatingSystem.isUnix()) {
        return new VFSFile(path, path, path, VFSFile.DIRECTORY, 0L, false);
    }
    File file = new File(path);
    if (!file.exists())
        return null;
    return new LocalFile(file);
}