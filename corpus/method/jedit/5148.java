public boolean accept(String filePath, String fileName, String firstLine) {
    return acceptFile(filePath, fileName) || acceptIdentical(filePath, fileName) || acceptFirstLine(firstLine);
}