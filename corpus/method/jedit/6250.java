static int getFlag(boolean ignoreCase) {
    int flags = Pattern.MULTILINE;
    if (ignoreCase)
        flags |= Pattern.CASE_INSENSITIVE;
    return flags;
}