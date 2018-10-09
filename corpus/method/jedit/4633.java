//}}}
//{{{ _createOutputStream() method
public OutputStream _createOutputStream(Object session, String path, Component comp) throws IOException {
    try {
        return new URL(path).openConnection().getOutputStream();
    } catch (MalformedURLException mu) {
        Log.log(Log.ERROR, this, mu);
        String[] args = { mu.getMessage() };
        VFSManager.error(comp, path, "ioerror.badurl", args);
        return null;
    }
}