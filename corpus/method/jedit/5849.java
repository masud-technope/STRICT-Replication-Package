//{{{ runInAWTThread() method
public void runInAWTThread(Component comp) {
    // check if download failed
    if (path == null)
        return;
    /* if download OK, remove existing version
			 * and bundled jars and files */
    if (installed != null) {
        PluginJAR pluginJar = jEdit.getPluginJAR(installed);
        Collection<String> libs = new LinkedList();
        libs.add(installed);
        if (pluginJar == null) {
            Log.log(Log.ERROR, Roster.Remove.class, "unable to get PluginJAR for " + installed);
        } else {
            libs.addAll(pluginJar.getJars());
            libs.addAll(pluginJar.getFiles());
        }
        for (String lib : libs) {
            new Remove(lib).runInAWTThread(comp);
        }
    }
    ZipFile zipFile = null;
    try {
        zipFile = new ZipFile(path);
        Enumeration<? extends ZipEntry> e = zipFile.entries();
        while (e.hasMoreElements()) {
            ZipEntry entry = e.nextElement();
            String name = entry.getName().replace('/', File.separatorChar);
            File file = new File(installDirectory, name);
            if (entry.isDirectory())
                file.mkdirs();
            else {
                new File(file.getParent()).mkdirs();
                InputStream in = null;
                FileOutputStream out = null;
                try {
                    in = zipFile.getInputStream(entry);
                    // containing non-ascii characaters, #3531320
                    if (in == null)
                        throw new ZipException("Entry " + entry.getName() + " from archive " + zipFile.getName() + " could not be processed.");
                    out = new FileOutputStream(file);
                    IOUtilities.copyStream(4096, null, in, out, false);
                } finally {
                    IOUtilities.closeQuietly((Closeable) in);
                    IOUtilities.closeQuietly((Closeable) out);
                }
                if (file.getName().toLowerCase().endsWith(".jar"))
                    toLoad.add(file.getPath());
            }
        }
    } catch (InterruptedIOException iio) {
    } catch (ZipException e) {
        Log.log(Log.ERROR, this, e);
        GUIUtilities.error(null, "plugin-error-download", new Object[] { "" });
    } catch (IOException io) {
        Log.log(Log.ERROR, this, io);
        String[] args = { io.getMessage() };
        GUIUtilities.error(null, "ioerror", args);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
    } finally {
        try {
            if (zipFile != null)
                zipFile.close();
        } catch (IOException io) {
            Log.log(Log.ERROR, this, io);
        }
        if (jEdit.getBooleanProperty("plugin-manager.deleteDownloads")) {
            new File(path).delete();
        }
    }
//}}}
}