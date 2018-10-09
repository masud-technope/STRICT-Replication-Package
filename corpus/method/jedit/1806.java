// --------------------------------------------------------------------------
// Conversion to type descriptors
// --------------------------------------------------------------------------
/**
   * Returns the descriptor corresponding to this Java type.
   *
   * @return the descriptor corresponding to this Java type.
   */
public String getDescriptor() {
    StringBuilder buf = new StringBuilder();
    getDescriptor(buf);
    return buf.toString();
}