 PropValue(Object value, boolean defaultValue) {
    if (value == null)
        throw new NullPointerException();
    this.value = value;
    this.defaultValue = defaultValue;
}