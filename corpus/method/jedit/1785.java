/**
   * Sets this item to an item that do not hold a primitive value.
   *
   * @param type the type of this item.
   * @param strVal1 first part of the value of this item.
   * @param strVal2 second part of the value of this item.
   * @param strVal3 third part of the value of this item.
   */
void set(final int type, final String strVal1, final String strVal2, final String strVal3) {
    this.type = type;
    this.strVal1 = strVal1;
    this.strVal2 = strVal2;
    this.strVal3 = strVal3;
    switch(type) {
        case ClassWriter.UTF8:
        case ClassWriter.STR:
        case ClassWriter.CLASS:
            hashCode = type + strVal1.hashCode();
            return;
        case ClassWriter.NAME_TYPE:
            hashCode = type + strVal1.hashCode() * strVal2.hashCode();
            return;
        //case ClassWriter.IMETH:
        default:
            hashCode = type + strVal1.hashCode() * strVal2.hashCode() * strVal3.hashCode();
            return;
    }
}