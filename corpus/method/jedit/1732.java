/**
   * Puts the given item in the constant pool's hash table. The hash table
   * <i>must</i> not already contains this item.
   *
   * @param i the item to be added to the constant pool's hash table.
   */
private void put(final Item i) {
    if (index > threshold) {
        int oldCapacity = table.length;
        Item oldMap[] = table;
        int newCapacity = oldCapacity * 2 + 1;
        Item newMap[] = new Item[newCapacity];
        threshold = (int) (newCapacity * 0.75);
        table = newMap;
        for (int j = oldCapacity; j-- > 0; ) {
            for (Item old = oldMap[j]; old != null; ) {
                Item e = old;
                old = old.next;
                int index = (e.hashCode & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }
    int index = (i.hashCode & 0x7FFFFFFF) % table.length;
    i.next = table[index];
    table[index] = i;
}