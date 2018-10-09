public String toString() {
    if (showFullPath)
        return nodeFile.getAbsolutePath();
    String paths[] = nodeFile.getAbsolutePath().split(fileSep);
    return paths[paths.length - 1];
}