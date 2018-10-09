// set the values in the margin text fields to be either the minimum
// supported by the printer or the last used margins or the currently
// set margins, also sets a range on the text fields so the user can't
// enter a value too small or too large. Note that it is still possible
// for the user to enter invalid margin values, e.g.
// top margin + bottom margin > printable area height.
void setDefaultMargins() {
    int units = getUnits();
    boolean integerOnly = units == MediaPrintableArea.MM;
    // get the last margins the user set
    Margins margins = (Margins) attributes.get(Margins.class);
    // get the minimum and maximum margins supported by the printer
    float[] minMargins = getMinimumMargins();
    float[] maxMargins = getMaximumMargins();
    // use the printer margins if there are no last used margins
    float[] marginValues = margins == null ? minMargins : margins.getMargins(units);
    // set the margin text area values
    NumericTextField[] numberFields = new NumericTextField[] { topMarginField, leftMarginField, rightMarginField, bottomMarginField };
    for (int i = 0; i < numberFields.length; i++) {
        NumericTextField field = numberFields[i];
        Float currentUserMargin = null;
        String text = field.getText();
        if (text != null && !text.isEmpty()) {
            currentUserMargin = Float.valueOf(text);
        }
        Float value = Float.valueOf(marginValues[i]);
        Float minMargin = Float.valueOf(minMargins[i]);
        Float maxMargin = Float.valueOf(maxMargins[i]);
        if (currentUserMargin == null || currentUserMargin < minMargin || currentUserMargin > maxMargin) {
            // current user margin is invalid
            field.setText(integerOnly ? String.valueOf(value.intValue()) : String.valueOf(value));
        }
        field.setMinValue(integerOnly ? Integer.valueOf(minMargin.intValue()) : Float.valueOf(minMargin));
        field.setMaxValue(integerOnly ? Integer.valueOf(maxMargin.intValue()) : Float.valueOf(maxMargin));
        field.setToolTipText("Min: " + minMargin + ", max: " + maxMargin);
    }
}