public boolean acceptFirstLine(String firstLine) {
    if (firstlineMatcher == null)
        return false;
    return firstLine != null && firstlineMatcher.reset(firstLine).matches();
}