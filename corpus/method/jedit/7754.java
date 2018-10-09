@Override
public int read(CharBuffer target) throws IOException {
    int len = target.remaining();
    char[] cbuf = new char[len];
    int n = read(cbuf, 0, len);
    if (n > 0) {
        target.put(cbuf, 0, n);
    }
    return n;
}