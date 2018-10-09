/**
   * Returns the type of the elements of this array type.
   * This method should only be used for an array type.
   *
   * @return Returns the type of the elements of this array type.
   */
public Type getElementType() {
    return getType(buf, off + getDimensions());
}