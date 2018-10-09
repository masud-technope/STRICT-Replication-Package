/**
   * Puts a byte and a short into this byte vector. The byte vector is
   * automatically enlarged if necessary.
   *
   * @param b a byte.
   * @param s a short.
   * @return this byte vector.
   */
public ByteVector put12(final int b, final int s) {
    int length = this.length;
    if (length + 3 > data.length) {
        enlarge(3);
    }
    byte[] data = this.data;
    data[length++] = (byte) b;
    data[length++] = (byte) (s >>> 8);
    data[length++] = (byte) s;
    this.length = length;
    return this;
}