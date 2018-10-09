public  NumericTextField(String text, int columns, boolean positiveOnly) {
    super(text, columns);
    this.positiveOnly = positiveOnly;
    integerOnly = true;
    minValue = positiveOnly ? Integer.valueOf(0) : Integer.MIN_VALUE;
    maxValue = Integer.MAX_VALUE;
    addFilter();
    loadInvalidStyle();
}