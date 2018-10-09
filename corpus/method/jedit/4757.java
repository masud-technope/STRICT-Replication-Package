//{{{ _loadClass() method
/**
	 * Load class from this JAR only.
	 */
private synchronized Class _loadClass(String clazz, boolean resolveIt) throws ClassNotFoundException {
    jar.activatePlugin();
    synchronized (this) {
        Class cls = findLoadedClass(clazz);
        if (cls != null) {
            if (resolveIt)
                resolveClass(cls);
            return cls;
        }
        String name = MiscUtilities.classToFile(clazz);
        try {
            definePackage(clazz);
            ZipFile zipFile = jar.getZipFile();
            ZipEntry entry = zipFile.getEntry(name);
            if (entry == null)
                throw new ClassNotFoundException(clazz);
            InputStream in = zipFile.getInputStream(entry);
            int len = (int) entry.getSize();
            byte[] data = new byte[len];
            int success = 0;
            int offset = 0;
            while (success < len) {
                len -= success;
                offset += success;
                success = in.read(data, offset, len);
                if (success == -1) {
                    Log.log(Log.ERROR, this, "Failed to load class " + clazz + " from " + zipFile.getName());
                    throw new ClassNotFoundException(clazz);
                }
            }
            cls = defineClass(clazz, data, 0, data.length);
            if (resolveIt)
                resolveClass(cls);
            return cls;
        } catch (IOException io) {
            Log.log(Log.ERROR, this, io);
            throw new ClassNotFoundException(clazz);
        }
    }
}