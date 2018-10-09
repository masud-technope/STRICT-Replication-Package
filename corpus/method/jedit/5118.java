public static int getFirstSeparatorIndex(String path) {
    int start = getPathStart(path);
    int index = path.indexOf('/', start);
    if (index == -1)
        index = path.indexOf(File.separatorChar, start);
    return index;
}