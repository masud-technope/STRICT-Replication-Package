//{{{ Occur constructor
 Occur(int start, int end) {
    this.start = start;
    this.end = end;
    if (buffer != null && !buffer.isTemporary())
        bufferOpened();
//}}}
}