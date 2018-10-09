public  LocalFile(File file) {
    this.file = file;
    setName(file.getName());
    String path = file.getPath();
    setPath(path);
    setDeletePath(path);
    setHidden(file.isHidden());
    setType(file.isDirectory() ? VFSFile.DIRECTORY : VFSFile.FILE);
}