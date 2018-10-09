@Override
public InputStream _createInputStream(Object session, String path, boolean ignoreErrors, Component comp) throws IOException {
    try {
        return new FileInputStream(path);
    } catch (IOException io) {
        if (ignoreErrors)
            return null;
        else
            throw io;
    }
}