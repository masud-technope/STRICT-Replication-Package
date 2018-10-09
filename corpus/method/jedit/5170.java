public boolean getBooleanProperty(String key) {
    Object value = getProperty(key);
    return StandardUtilities.getBoolean(value, false);
}