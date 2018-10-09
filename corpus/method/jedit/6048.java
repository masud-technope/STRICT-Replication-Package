//}}}
//{{{ loadProps() method
private static void loadProps(Properties into, Reader in) throws IOException {
    try {
        into.load(in);
    } finally {
        in.close();
    }
}