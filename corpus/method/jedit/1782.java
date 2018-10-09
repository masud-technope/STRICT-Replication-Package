/**
   * Indicates if the given item is equal to this one.
   *
   * @param i the item to be compared to this one.
   * @return <tt>true</tt> if the given item if equal to this one,
   *      <tt>false</tt> otherwise.
   */
boolean isEqualTo(final Item i) {
    if (i.type == type) {
        switch(type) {
            case ClassWriter.INT:
                return i.intVal == intVal;
            case ClassWriter.LONG:
                return i.longVal == longVal;
            case ClassWriter.FLOAT:
                return i.floatVal == floatVal;
            case ClassWriter.DOUBLE:
                return i.doubleVal == doubleVal;
            case ClassWriter.UTF8:
            case ClassWriter.STR:
            case ClassWriter.CLASS:
                return i.strVal1.equals(strVal1);
            case ClassWriter.NAME_TYPE:
                return i.strVal1.equals(strVal1) && i.strVal2.equals(strVal2);
            //case ClassWriter.IMETH:
            default:
                return i.strVal1.equals(strVal1) && i.strVal2.equals(strVal2) && i.strVal3.equals(strVal3);
        }
    }
    return false;
}