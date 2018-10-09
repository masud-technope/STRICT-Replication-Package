//{{{ write() method
public synchronized void write(int b) {
    byte[] barray = { (byte) b };
    write(barray, 0, 1);
//}}}
}