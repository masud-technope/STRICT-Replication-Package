/**
   * Adds a string to the constant pool of the class being build. Does nothing
   * if the constant pool already contains a similar item.
   *
   * @param value the String value.
   * @return a new or already existing string item.
   */
private Item newString(final String value) {
    key2.set(STR, value, null, null);
    Item result = get(key2);
    if (result == null) {
        pool.put12(STR, newUTF8(value).index);
        result = new Item(index++, key2);
        put(result);
    }
    return result;
}