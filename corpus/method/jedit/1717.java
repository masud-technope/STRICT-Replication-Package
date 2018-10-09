/**
   * Adds a method reference to the constant pool of the class being build. Does
   * nothing if the constant pool already contains a similar item.
   *
   * @param owner the internal name of the method's owner class.
   * @param name the method's name.
   * @param desc the method's descriptor.
   * @return a new or already existing method reference item.
   */
Item newMethod(final String owner, final String name, final String desc) {
    key3.set(METH, owner, name, desc);
    Item result = get(key3);
    if (result == null) {
        put122(METH, newClass(owner).index, newNameType(name, desc).index);
        result = new Item(index++, key3);
        put(result);
    }
    return result;
}