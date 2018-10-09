/**
   * Adds an interface method reference to the constant pool of the class being
   * build. Does nothing if the constant pool already contains a similar item.
   *
   * @param ownerItf the internal name of the method's owner interface.
   * @param name the method's name.
   * @param desc the method's descriptor.
   * @return a new or already existing interface method reference item.
   */
Item newItfMethod(final String ownerItf, final String name, final String desc) {
    key3.set(IMETH, ownerItf, name, desc);
    Item result = get(key3);
    if (result == null) {
        put122(IMETH, newClass(ownerItf).index, newNameType(name, desc).index);
        result = new Item(index++, key3);
        put(result);
    }
    return result;
}