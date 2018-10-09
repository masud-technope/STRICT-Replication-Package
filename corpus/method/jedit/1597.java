static String prefix(String value, int parts) {
    if (parts < 1)
        return null;
    int count = 0;
    int index = -1;
    while (((index = value.indexOf('.', index + 1)) != -1) && (++count < parts)) {
        ;
    }
    return (index == -1) ? value : value.substring(0, index);
}