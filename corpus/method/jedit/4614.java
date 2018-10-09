@Override
public boolean insert(View view, Buffer buffer, String path) {
    File file = new File(path);
    if (!file.exists())
        return false;
    if (file.isDirectory()) {
        VFSManager.error(view, file.getPath(), "ioerror.open-directory", null);
        return false;
    }
    if (!file.canRead()) {
        VFSManager.error(view, file.getPath(), "ioerror.no-read", null);
        return false;
    }
    return super.insert(view, buffer, path);
}