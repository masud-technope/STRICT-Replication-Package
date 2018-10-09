/**
   * Returns the constant pool's hash table item which is equal to the given
   * item.
   *
   * @param key a constant pool item.
   * @return the constant pool's hash table item which is equal to the given
   *      item, or <tt>null</tt> if there is no such item.
   */
private Item get(final Item key) {
    Item tab[] = table;
    int hashCode = key.hashCode;
    int index = (hashCode & 0x7FFFFFFF) % tab.length;
    for (Item i = tab[index]; i != null; i = i.next) {
        if (i.hashCode == hashCode && key.isEqualTo(i)) {
            return i;
        }
    }
    return null;
}