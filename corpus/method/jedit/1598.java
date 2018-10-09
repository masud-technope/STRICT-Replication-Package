static String prefix(String value) {
    if (!isCompound(value))
        return null;
    return prefix(value, countParts(value) - 1);
}