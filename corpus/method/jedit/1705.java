/**
   * Puts a byte into this byte vector. The byte vector is automatically
   * enlarged if necessary.
   *
   * @param b a byte.
   * @return this byte vector.
   */
public ByteVector put1(final int b) {
    int length = this.length;
    if (length + 1 > data.length) {
        enlarge(1);
    }
    data[length++] = (byte) b;
    this.length = length;
    return this;
}