//{{{ saveMirrorList() method
private void saveMirrorList(String xml) {
    String settingsDirectory = jEdit.getSettingsDirectory();
    if (settingsDirectory == null)
        return;
    File mirrorList = new File(MiscUtilities.constructPath(settingsDirectory, "mirrorList.xml"));
    OutputStream out = null;
    try {
        out = new BufferedOutputStream(new FileOutputStream(mirrorList));
        IOUtilities.copyStream(null, new ByteArrayInputStream(xml.getBytes()), out, false);
    } catch (IOException e) {
        Log.log(Log.ERROR, this, "Unable to write cached mirror list : " + mirrorList);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
//}}}
}