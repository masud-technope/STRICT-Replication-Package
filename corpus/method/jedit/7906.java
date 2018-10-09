@After
public void tearDown() {
    closeQuietly((Closeable) reader);
    closeQuietly((Closeable) writer);
}