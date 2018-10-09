@Override
public VFSFile[] _listFiles(Object session, String path, Component comp) {
    if (OperatingSystem.isWindows()) {
        if (path.length() == 2 && path.charAt(1) == ':')
            path = path.concat(File.separator);
    }
    File directory = new File(path);
    File[] list = null;
    if (directory.exists()) {
        if (fsView == null)
            fsView = FileSystemView.getFileSystemView();
        list = fsView.getFiles(directory, false);
    }
    if (list == null) {
        VFSManager.error(comp, path, "ioerror.directory-error-nomsg", null);
        return null;
    }
    VFSFile[] list2 = new VFSFile[list.length];
    for (int i = 0; i < list.length; i++) list2[i] = new LocalFile(list[i]);
    return list2;
}