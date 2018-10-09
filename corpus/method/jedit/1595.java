public static String suffix(String value, int parts) {
    if (parts < 1)
        return null;
    int count = 0;
    int index = value.length() + 1;
    while (((index = value.lastIndexOf('.', index - 1)) != -1) && (++count < parts)) ;
    return (index == -1) ? value : value.substring(index + 1);
}