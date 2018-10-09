// }}}
//{{{ loadProperties() method
private static Properties loadProperties(String fileName) {
    Properties props = new Properties();
    File file;
    if (fileName.charAt(0) == '/')
        file = new File(fileName.substring(1));
    else
        file = new File(fileName);
    InputStream in = null;
    try {
        if (file.isFile()) {
            in = new FileInputStream(file);
        } else {
            in = TextArea.class.getResourceAsStream(fileName);
        }
        props.load(in);
    } catch (IOException e) {
        Log.log(Log.ERROR, TextArea.class, e);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
    }
    return props;
}