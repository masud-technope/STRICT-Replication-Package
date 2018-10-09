@Override
public int read(char[] cbuf, int off, int len) throws IOException {
    if (cbuf == null) {
        throw new NullPointerException();
    } else if (off < 0 || len < 0 || len > cbuf.length - off) {
        throw new IndexOutOfBoundsException();
    }
    int readChar = read();
    if (readChar == -1) {
        return -1;
    }
    if (len == 0) {
        return 0;
    }
    cbuf[off] = (char) readChar;
    return 1;
}