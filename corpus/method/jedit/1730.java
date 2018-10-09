/**
   * Adds an UTF string to the constant pool of the class being build. Does
   * nothing if the constant pool already contains a similar item.
   *
   * @param value the String value.
   * @return a new or already existing UTF8 item.
   */
Item newUTF8(final String value) {
    key.set(UTF8, value, null, null);
    Item result = get(key);
    if (result == null) {
        pool.put1(UTF8).putUTF(value);
        result = new Item(index++, key);
        put(result);
    }
    return result;
}