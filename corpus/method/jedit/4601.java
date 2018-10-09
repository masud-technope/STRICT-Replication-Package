@Override
protected void fetchAttrs() {
    if (fetchedAttrs())
        return;
    super.fetchAttrs();
    setSymlinkPath(MiscUtilities.resolveSymlinks(file.getPath()));
    setReadable(file.canRead());
    setWriteable(file.canWrite());
    setLength(file.length());
    setModified(file.lastModified());
}