/**
   * Adds a field reference to the constant pool of the class being build. Does
   * nothing if the constant pool already contains a similar item.
   *
   * @param owner the internal name of the field's owner class.
   * @param name the field's name.
   * @param desc the field's descriptor.
   * @return a new or already existing field reference item.
   */
Item newField(final String owner, final String name, final String desc) {
    key3.set(FIELD, owner, name, desc);
    Item result = get(key3);
    if (result == null) {
        put122(FIELD, newClass(owner).index, newNameType(name, desc).index);
        result = new Item(index++, key3);
        put(result);
    }
    return result;
}