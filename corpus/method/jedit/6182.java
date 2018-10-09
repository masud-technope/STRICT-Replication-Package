//}}}
//{{{ bufferOpened() method
void bufferOpened(Buffer buffer) {
    this.buffer = buffer;
    Occur o = occur;
    while (o != null) {
        o.bufferOpened();
        o = o.next;
    }
}