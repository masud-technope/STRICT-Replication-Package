/**
   * Puts a short into this byte vector. The byte vector is automatically
   * enlarged if necessary.
   *
   * @param s a short.
   * @return this byte vector.
   */
public ByteVector put2(final int s) {
    int length = this.length;
    if (length + 2 > data.length) {
        enlarge(2);
    }
    byte[] data = this.data;
    data[length++] = (byte) (s >>> 8);
    data[length++] = (byte) s;
    this.length = length;
    return this;
}