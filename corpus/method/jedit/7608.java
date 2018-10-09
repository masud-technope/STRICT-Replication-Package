//{{{ write() method
public synchronized void write(byte[] b, int off, int len) {
    String str = new String(b, off, len);
    log(urgency, source, str);
//}}}
}