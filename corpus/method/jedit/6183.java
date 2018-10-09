//}}}
//{{{ bufferClosed() method
void bufferClosed() {
    buffer = null;
    Occur o = occur;
    while (o != null) {
        o.bufferClosed();
        o = o.next;
    }
}