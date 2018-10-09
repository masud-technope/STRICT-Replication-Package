//}}}
//{{{ getResource() method
/**
	 * overriding getResource() because we want to search FIRST in this
	 * ClassLoader, then the parent, the path, etc.
	 */
public URL getResource(String name) {
    try {
        if (jar != null) {
            ZipFile zipFile = jar.getZipFile();
            ZipEntry entry = zipFile.getEntry(name);
            if (entry != null) {
                return new URL(getResourceAsPath(name));
            }
        }
        Object obj = resourcesHash.get(name);
        if (obj instanceof JARClassLoader) {
            JARClassLoader classLoader = (JARClassLoader) obj;
            return classLoader.getResource(name);
        } else {
            URL ret = getSystemResource(name);
            if (ret != null) {
                Log.log(Log.DEBUG, JARClassLoader.class, "Would have returned null for getResource(" + name + ")");
                Log.log(Log.DEBUG, JARClassLoader.class, "returning(" + ret + ")");
            }
            return ret;
        }
    } catch (IOException io) {
        Log.log(Log.ERROR, this, io);
        return null;
    }
}