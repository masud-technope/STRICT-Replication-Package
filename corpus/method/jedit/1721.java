/**
   * Adds a long to the constant pool of the class being build. Does nothing if
   * the constant pool already contains a similar item.
   *
   * @param value the long value.
   * @return a new or already existing long item.
   */
private Item newLong(final long value) {
    key.set(value);
    Item result = get(key);
    if (result == null) {
        pool.put1(LONG).put8(value);
        result = new Item(index, key);
        put(result);
        index += 2;
    }
    return result;
}