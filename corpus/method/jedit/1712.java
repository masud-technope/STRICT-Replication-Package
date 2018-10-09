/**
   * Adds a name and type to the constant pool of the class being build. Does
   * nothing if the constant pool already contains a similar item.
   *
   * @param name a name.
   * @param desc a type descriptor.
   * @return a new or already existing name and type item.
   */
private Item newNameType(final String name, final String desc) {
    key2.set(NAME_TYPE, name, desc, null);
    Item result = get(key2);
    if (result == null) {
        put122(NAME_TYPE, newUTF8(name).index, newUTF8(desc).index);
        result = new Item(index++, key2);
        put(result);
    }
    return result;
}