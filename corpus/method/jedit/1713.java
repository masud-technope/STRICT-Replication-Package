/**
   * Adds a class reference to the constant pool of the class being build. Does
   * nothing if the constant pool already contains a similar item.
   *
   * @param value the internal name of the class.
   * @return a new or already existing class reference item.
   */
Item newClass(final String value) {
    key2.set(CLASS, value, null, null);
    Item result = get(key2);
    if (result == null) {
        pool.put12(CLASS, newUTF8(value).index);
        result = new Item(index++, key2);
        put(result);
    }
    return result;
}