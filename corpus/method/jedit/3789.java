private boolean inRange(String string) {
    if (string == null || string.isEmpty()) {
        return false;
    }
    if (".".equals(string)) {
        return true;
    }
    float value = Float.parseFloat(string);
    boolean toReturn = value <= maxValue.floatValue() && value >= minValue.floatValue();
    return toReturn;
}