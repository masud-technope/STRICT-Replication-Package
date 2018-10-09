public static String getCompleteBaseName(String path) {
    String name = getFileName(path);
    int index = name.lastIndexOf('.');
    if (index == -1)
        return name;
    return name.substring(0, index);
}