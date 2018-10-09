//}}}
//{{{ getResourceAsStream() method
public InputStream getResourceAsStream(String name) {
    try {
        // try in current jar first
        if (jar != null) {
            ZipFile zipFile = jar.getZipFile();
            ZipEntry entry = zipFile.getEntry(name);
            if (entry != null) {
                return zipFile.getInputStream(entry);
            }
        }
        // then try from another jar
        Object obj = resourcesHash.get(name);
        if (obj instanceof JARClassLoader) {
            JARClassLoader classLoader = (JARClassLoader) obj;
            return classLoader.getResourceAsStream(name);
        }
        // finally try from the system class loader
        return getSystemResourceAsStream(name);
    } catch (IOException io) {
        Log.log(Log.ERROR, this, io);
        return null;
    }
}