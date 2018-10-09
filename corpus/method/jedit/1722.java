public  ClassWriter(final boolean computeMaxs) {
    index = 1;
    pool = new ByteVector();
    table = new Item[64];
    threshold = (int) (0.75d * table.length);
    key = new Item();
    key2 = new Item();
    key3 = new Item();
    this.computeMaxs = computeMaxs;
}