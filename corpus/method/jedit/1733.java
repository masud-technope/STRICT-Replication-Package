/**
   * Puts one byte and two shorts into the constant pool.
   *
   * @param b a byte.
   * @param s1 a short.
   * @param s2 another short.
   */
private void put122(final int b, final int s1, final int s2) {
    pool.put12(b, s1).put2(s2);
}