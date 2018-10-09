public static int getLastSeparatorIndex(String path) {
    int start = getPathStart(path);
    if (start != 0)
        path = path.substring(start);
    int index = Math.max(path.lastIndexOf('/'), path.lastIndexOf(File.separatorChar));
    if (index == -1)
        return index;
    else
        return index + start;
}