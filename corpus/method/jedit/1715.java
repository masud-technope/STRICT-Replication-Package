/**
   * Adds an integer to the constant pool of the class being build. Does nothing
   * if the constant pool already contains a similar item.
   *
   * @param value the int value.
   * @return a new or already existing int item.
   */
private Item newInteger(final int value) {
    key.set(value);
    Item result = get(key);
    if (result == null) {
        pool.put1(INT).put4(value);
        result = new Item(index++, key);
        put(result);
    }
    return result;
}