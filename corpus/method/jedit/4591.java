@Override
public boolean _delete(Object session, String path, Component comp) {
    File file = new File(path);
    String canonPath;
    try {
        canonPath = file.getCanonicalPath();
    } catch (IOException io) {
        canonPath = path;
    }
    boolean retVal;
    if (!file.isDirectory()) {
        retVal = file.delete();
    } else {
        retVal = recursiveDelete(file);
    }
    if (retVal)
        VFSManager.sendVFSUpdate(this, canonPath, true);
    return retVal;
}