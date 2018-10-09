static int countParts(String value) {
    if (value == null)
        return 0;
    int count = 0;
    int index = -1;
    while ((index = value.indexOf('.', index + 1)) != -1) count++;
    return count + 1;
}