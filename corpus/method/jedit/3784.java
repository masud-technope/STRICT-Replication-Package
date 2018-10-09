private boolean inRange(String string) {
    if (string == null || string.isEmpty()) {
        return false;
    }
    int value = Integer.parseInt(string);
    return value <= maxValue.intValue() && value >= minValue.intValue();
}