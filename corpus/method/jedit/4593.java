@Override
public boolean _mkdir(Object session, String directory, Component comp) {
    String parent = getParentOfPath(directory);
    if (!new File(parent).exists()) {
        if (!_mkdir(session, parent, comp))
            return false;
    }
    File file = new File(directory);
    boolean retVal = file.mkdir();
    String canonPath;
    try {
        canonPath = file.getCanonicalPath();
    } catch (IOException io) {
        canonPath = directory;
    }
    VFSManager.sendVFSUpdate(this, canonPath, true);
    return retVal;
}