//}}}
//{{{ loadProperties() method
private void loadProperties() {
    props = new Properties();
    InputStream in = null;
    try {
        in = new BufferedInputStream(new FileInputStream(file));
        props.load(in);
    } catch (IOException e) {
        Log.log(Log.ERROR, this, "Unable to load properties", e);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
    }
}