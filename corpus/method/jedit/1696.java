/**
   * Puts an array of bytes into this byte vector. The byte vector is
   * automatically enlarged if necessary.
   *
   * @param b an array of bytes. May be <tt>null</tt> to put <tt>len</tt> null
   *      bytes into this byte vector.
   * @param off index of the fist byte of b that must be copied.
   * @param len number of bytes of b that must be copied.
   * @return this byte vector.
   */
public ByteVector putByteArray(final byte[] b, final int off, final int len) {
    if (length + len > data.length) {
        enlarge(len);
    }
    if (b != null) {
        System.arraycopy(b, off, data, length, len);
    }
    length += len;
    return this;
}