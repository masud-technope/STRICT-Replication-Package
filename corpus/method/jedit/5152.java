public boolean acceptIdentical(String filePath, String fileName) {
    String filenameGlob = (String) getProperty("filenameGlob");
    if (filenameGlob == null)
        return false;
    if (fileName != null && fileName.equalsIgnoreCase(filenameGlob))
        return true;
    if (filePath != null) {
        int lastUnixPos = filePath.lastIndexOf('/');
        int lastWindowsPos = filePath.lastIndexOf('\\');
        int index = Math.max(lastUnixPos, lastWindowsPos);
        String filename = filePath.substring(index + 1);
        return filename.equalsIgnoreCase(filenameGlob);
    }
    return false;
}