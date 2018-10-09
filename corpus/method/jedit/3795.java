// set the minimum allowed value for this text field. If this NumericTextField
// was constructed with positive only, then values less than zero are ignored.
public void setMinValue(Number n) {
    if (positiveOnly) {
        float f = n.floatValue();
        if (f < 0.0)
            return;
    }
    if (integerOnly) {
        int i = n.intValue();
        int max = maxValue.intValue();
        if (i > max)
            return;
    } else {
        float f = n.floatValue();
        float max = maxValue.floatValue();
        if (f > max)
            return;
    }
    minValue = n;
}