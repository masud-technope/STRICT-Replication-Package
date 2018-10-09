static String suffix(String name) {
    if (!isCompound(name))
        return null;
    return suffix(name, countParts(name) - 1);
}