public String getLayoutFilename(String baseName, int viewIndex) {
    String dir = getLayoutDirectory();
    if (dir == null)
        return null;
    return dir + File.separator + layoutToFile(baseName, viewIndex);
}