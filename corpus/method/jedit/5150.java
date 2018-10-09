public boolean acceptFile(String filePath, String fileName) {
    if (filepathMatcher == null)
        return false;
    return fileName != null && filepathMatcher.reset(fileName).matches() || filePath != null && filepathMatcher.reset(filePath).matches();
}