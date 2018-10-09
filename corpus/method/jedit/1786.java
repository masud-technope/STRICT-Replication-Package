/**
   * Sets this item to a {@link ClassWriter#DOUBLE DOUBLE} item.
   *
   * @param doubleVal the value of this item.
   */
void set(final double doubleVal) {
    this.type = ClassWriter.DOUBLE;
    this.doubleVal = doubleVal;
    this.hashCode = type + (int) doubleVal;
}