void saveState(String vfsURL, List<Entry> pluginList) {
    StringBuilder sb = new StringBuilder("<pluginset>\n ");
    for (Entry entry : pluginList) {
        String jarName = entry.jar.substring(1 + entry.jar.lastIndexOf(File.separatorChar));
        sb.append("   <plugin name=\"").append(entry.name).append("\" jar=\"");
        sb.append(jarName).append("\" />\n ");
    }
    sb.append("</pluginset>\n");
    VFS vfs = VFSManager.getVFSForPath(vfsURL);
    Object session = vfs.createVFSSession(vfsURL, ManagePanel.this);
    Writer writer = null;
    try {
        OutputStream os = vfs._createOutputStream(session, vfsURL, ManagePanel.this);
        writer = new BufferedWriter(new OutputStreamWriter(os, "utf-8"));
        writer.write(sb.toString());
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Saving State Error", e);
    } finally {
        IOUtilities.closeQuietly((Closeable) writer);
    }
}