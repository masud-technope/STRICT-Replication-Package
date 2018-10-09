/**
   * Puts an int into this byte vector. The byte vector is automatically
   * enlarged if necessary.
   *
   * @param i an int.
   * @return this byte vector.
   */
public ByteVector put4(final int i) {
    int length = this.length;
    if (length + 4 > data.length) {
        enlarge(4);
    }
    byte[] data = this.data;
    data[length++] = (byte) (i >>> 24);
    data[length++] = (byte) (i >>> 16);
    data[length++] = (byte) (i >>> 8);
    data[length++] = (byte) i;
    this.length = length;
    return this;
}