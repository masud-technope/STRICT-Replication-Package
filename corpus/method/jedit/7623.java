public String toString() {
    int baseLength = base.length();
    StringBuilder builder = new StringBuilder(baseLength);
    for (int i = baseLength - 1; i >= 0; --i) {
        builder.append(base.charAt(i));
    }
    return builder.toString();
}