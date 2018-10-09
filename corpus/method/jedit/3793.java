public  NumericTextField(String text, int columns, boolean positiveOnly, boolean integerOnly) {
    super(text, columns);
    this.positiveOnly = positiveOnly;
    this.integerOnly = integerOnly;
    if (integerOnly) {
        minValue = positiveOnly ? Integer.valueOf(0) : Integer.MIN_VALUE;
        maxValue = Integer.MAX_VALUE;
    } else {
        minValue = positiveOnly ? Float.valueOf(0.0f) : Float.MIN_VALUE;
        maxValue = Float.MAX_VALUE;
    }
    addFilter();
    loadInvalidStyle();
}