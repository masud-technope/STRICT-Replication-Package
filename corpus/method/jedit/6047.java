//}}}
//{{{ loadProps() method
private static void loadProps(Properties into, InputStream in) throws IOException {
    try {
        into.load(in);
    } finally {
        in.close();
    }
}