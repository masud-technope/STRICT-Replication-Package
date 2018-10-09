public static String getFileExtension(String path) {
    int fsIndex = getLastSeparatorIndex(path);
    int index = path.lastIndexOf('.');
    if (index == -1 || index < fsIndex)
        return "";
    else
        return path.substring(index);
}