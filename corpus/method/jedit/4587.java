 Root(File file) {
    // REMIND: calling isDirectory() on a floppy drive
    // displays stupid I/O error dialog box on Windows
    String path = file.getPath();
    setPath(path);
    setDeletePath(path);
    setSymlinkPath(path);
    if (fsView.isFloppyDrive(file)) {
        setType(VFSFile.FILESYSTEM);
        setName(path);
    } else if (fsView.isDrive(file)) {
        setType(VFSFile.FILESYSTEM);
        setName(path + ' ' + fsView.getSystemDisplayName(file));
    } else if (file.isDirectory()) {
        if (fsView.isFileSystemRoot(file))
            setType(VFSFile.DIRECTORY);
        else
            setType(VFSFile.FILESYSTEM);
        if (OperatingSystem.isMacOS())
            setName(MiscUtilities.getFileName(path));
        else
            setName(path);
    } else
        setType(VFSFile.FILE);
}