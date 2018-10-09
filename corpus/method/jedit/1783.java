/**
   * Sets this item to a {@link ClassWriter#FLOAT FLOAT} item.
   *
   * @param floatVal the value of this item.
   */
void set(final float floatVal) {
    this.type = ClassWriter.FLOAT;
    this.floatVal = floatVal;
    this.hashCode = type + (int) floatVal;
}