public static String getBaseName(String path) {
    String name = getFileName(path);
    int index = name.indexOf('.');
    if (index == -1)
        return name;
    else
        return name.substring(0, index);
}