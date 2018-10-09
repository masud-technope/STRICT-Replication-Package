/**
   * Puts a String in UTF format into this byte vector. The byte vector is
   * automatically enlarged if necessary.
   *
   * @param s a String.
   * @return this byte vector.
   */
public ByteVector putUTF(final String s) {
    int charLength = s.length();
    int byteLength = 0;
    for (int i = 0; i < charLength; ++i) {
        char c = s.charAt(i);
        if (c >= '\001' && c <= '\177') {
            byteLength++;
        } else if (c > '?') {
            byteLength += 3;
        } else {
            byteLength += 2;
        }
    }
    if (byteLength > 65535) {
        throw new IllegalArgumentException();
    }
    int length = this.length;
    if (length + 2 + byteLength > data.length) {
        enlarge(2 + byteLength);
    }
    byte[] data = this.data;
    data[length++] = (byte) (byteLength >>> 8);
    data[length++] = (byte) (byteLength);
    for (int i = 0; i < charLength; ++i) {
        char c = s.charAt(i);
        if (c >= '\001' && c <= '\177') {
            data[length++] = (byte) c;
        } else if (c > '?') {
            data[length++] = (byte) (0xE0 | c >> 12 & 0xF);
            data[length++] = (byte) (0x80 | c >> 6 & 0x3F);
            data[length++] = (byte) (0x80 | c & 0x3F);
        } else {
            data[length++] = (byte) (0xC0 | c >> 6 & 0x1F);
            data[length++] = (byte) (0x80 | c & 0x3F);
        }
    }
    this.length = length;
    return this;
}