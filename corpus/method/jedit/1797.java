// --------------------------------------------------------------------------
// Corresponding size and opcodes
// --------------------------------------------------------------------------
/**
   * Returns the size of values of this type.
   *
   * @return the size of values of this type, i.e., 2 for <tt>long</tt> and
   *      <tt>double</tt>, and 1 otherwise.
   */
public int getSize() {
    return (sort == LONG || sort == DOUBLE ? 2 : 1);
}