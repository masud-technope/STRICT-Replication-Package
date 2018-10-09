//}}}
//{{{ append() method
public void append(char[] text, int off, int len) {
    ensureCapacity(count + len);
    System.arraycopy(text, off, array, count, len);
    count += len;
}