/**
   * Adds a float to the constant pool of the class being build. Does nothing if
   * the constant pool already contains a similar item.
   *
   * @param value the float value.
   * @return a new or already existing float item.
   */
private Item newFloat(final float value) {
    key.set(value);
    Item result = get(key);
    if (result == null) {
        pool.put1(FLOAT).put4(Float.floatToIntBits(value));
        result = new Item(index++, key);
        put(result);
    }
    return result;
}