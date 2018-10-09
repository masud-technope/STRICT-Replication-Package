public  BufferSegment(char[] data, int offset, int len, BufferSegment next) {
    this.data = data;
    this.offset = offset;
    this.len = len;
    this.next = next;
}