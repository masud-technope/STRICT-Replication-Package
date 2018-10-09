/**
   * Adds a double to the constant pool of the class being build. Does nothing
   * if the constant pool already contains a similar item.
   *
   * @param value the double value.
   * @return a new or already existing double item.
   */
private Item newDouble(final double value) {
    key.set(value);
    Item result = get(key);
    if (result == null) {
        pool.put1(DOUBLE).put8(Double.doubleToLongBits(value));
        result = new Item(index, key);
        put(result);
        index += 2;
    }
    return result;
}