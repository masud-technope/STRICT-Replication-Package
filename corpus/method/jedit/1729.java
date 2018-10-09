// --------------------------------------------------------------------------
// Utility methods: constant pool management
// --------------------------------------------------------------------------
/**
   * Adds a number or string constant to the constant pool of the class being
   * build. Does nothing if the constant pool already contains a similar item.
   *
   * @param cst the value of the constant to be added to the constant pool. This
   *      parameter must be an {@link java.lang.Integer Integer}, a {@link
   *      java.lang.Float Float}, a {@link java.lang.Long Long}, a {@link
          java.lang.Double Double} or a {@link String String}.
   * @return a new or already existing constant item with the given value.
   */
Item newCst(final Object cst) {
    if (cst instanceof Integer) {
        int val = ((Integer) cst).intValue();
        return newInteger(val);
    } else if (cst instanceof Float) {
        float val = ((Float) cst).floatValue();
        return newFloat(val);
    } else if (cst instanceof Long) {
        long val = ((Long) cst).longValue();
        return newLong(val);
    } else if (cst instanceof Double) {
        double val = ((Double) cst).doubleValue();
        return newDouble(val);
    } else if (cst instanceof String) {
        return newString((String) cst);
    } else {
        throw new IllegalArgumentException("value " + cst);
    }
}