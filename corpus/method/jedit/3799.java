public  NumericTextField(String text, boolean positiveOnly) {
    super(text);
    this.positiveOnly = positiveOnly;
    integerOnly = true;
    minValue = positiveOnly ? Integer.valueOf(0) : Integer.MIN_VALUE;
    maxValue = Integer.MAX_VALUE;
    addFilter();
    loadInvalidStyle();
}