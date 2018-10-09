// set the maximum allowed value for this text field. If this NumericTextField
// was constructed with positive only, then values less than zero are ignored.
public void setMaxValue(Number n) {
    if (positiveOnly) {
        float f = n.floatValue();
        if (f < 0)
            return;
    }
    if (integerOnly) {
        int i = n.intValue();
        int min = minValue.intValue();
        if (i < min)
            return;
    } else {
        float f = n.floatValue();
        float min = minValue.floatValue();
        if (f < min)
            return;
    }
    maxValue = n;
}