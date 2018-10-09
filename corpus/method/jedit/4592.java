@Override
public boolean _rename(Object session, String from, String to, Component comp) {
    File _to = new File(to);
    String toCanonPath;
    try {
        toCanonPath = _to.getCanonicalPath();
    } catch (IOException io) {
        toCanonPath = to;
    }
    File parent = new File(_to.getParent());
    if (parent.exists()) {
        if (!parent.isDirectory())
            return false;
    } else {
        parent.mkdirs();
        if (!parent.exists())
            return false;
    }
    File _from = new File(from);
    String fromCanonPath;
    try {
        fromCanonPath = _from.getCanonicalPath();
    } catch (IOException io) {
        fromCanonPath = from;
    }
    if (!fromCanonPath.equalsIgnoreCase(toCanonPath))
        _to.delete();
    boolean retVal = _from.renameTo(_to);
    VFSManager.sendVFSUpdate(this, fromCanonPath, true);
    VFSManager.sendVFSUpdate(this, toCanonPath, true);
    return retVal;
}