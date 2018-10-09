/**
   * Sets this item to an {@link ClassWriter#INT INT} item.
   *
   * @param intVal the value of this item.
   */
void set(final int intVal) {
    this.type = ClassWriter.INT;
    this.intVal = intVal;
    this.hashCode = type + intVal;
}