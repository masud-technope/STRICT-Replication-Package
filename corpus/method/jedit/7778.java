public int getCardinalProperty(String name, int defaultValue) {
    int result = jEdit.getIntegerProperty(name, defaultValue);
    if (result <= 0)
        result = defaultValue;
    return result;
}