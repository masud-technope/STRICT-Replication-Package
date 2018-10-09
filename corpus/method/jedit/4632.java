//}}}
//{{{ _createInputStream() method
public InputStream _createInputStream(Object session, String path, boolean ignoreErrors, Component comp) throws IOException {
    try {
        return new URL(path).openStream();
    } catch (MalformedURLException mu) {
        Log.log(Log.ERROR, this, mu);
        String[] args = { mu.getMessage() };
        VFSManager.error(comp, path, "ioerror.badurl", args);
        return null;
    }
}