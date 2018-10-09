/**
   * Returns the name of the class corresponding to this object type.
   * This method should only be used for an object type.
   *
   * @return the fully qualified name of the class corresponding to this object
   *      type.
   */
public String getClassName() {
    return new String(buf, off + 1, len - 2).replace('/', '.');
}