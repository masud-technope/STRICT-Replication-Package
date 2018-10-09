/**
   * Returns the internal name of the class corresponding to this object type.
   * The internal name of a class is its fully qualified name, where '.' are
   * replaced by '/'.   * This method should only be used for an object type.
   *
   * @return the internal name of the class corresponding to this object type.
   */
public String getInternalName() {
    return new String(buf, off + 1, len - 2);
}