public String toString() {
    if (showFullPath)
        return path;
    String[] paths = path.split(fileSep);
    return paths[paths.length - 1];
}