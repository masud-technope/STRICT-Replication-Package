/**
   * Sets this item to a {@link ClassWriter#LONG LONG} item.
   *
   * @param longVal the value of this item.
   */
void set(final long longVal) {
    this.type = ClassWriter.LONG;
    this.longVal = longVal;
    this.hashCode = type + (int) longVal;
}