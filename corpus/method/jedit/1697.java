/**
   * Enlarge this byte vector so that it can receive n more bytes.
   *
   * @param size number of additional bytes that this byte vector should be
   *      able to receive.
   */
private void enlarge(final int size) {
    byte[] newData = new byte[Math.max(2 * data.length, length + size)];
    System.arraycopy(data, 0, newData, 0, length);
    data = newData;
}