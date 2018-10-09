public String detectEncoding(InputStream sample) throws IOException {
    InputStreamReader reader = new InputStreamReader(sample);
    final int bufferSize = 1024;
    char[] buffer = new char[bufferSize];
    int readSize = reader.read(buffer, 0, bufferSize);
    if (readSize > 0) {
        Matcher matcher = pattern.matcher(CharBuffer.wrap(buffer, 0, readSize));
        // Tracking of this implicit state within Matcher
        // is required to know where is the start of
        // replacement after calling appendReplacement().
        int appendPosition = 0;
        while (matcher.find()) {
            String extracted = extractReplacement(matcher, appendPosition, replacement);
            if (EncodingServer.hasEncoding(extracted)) {
                return extracted;
            }
            appendPosition = matcher.end();
        }
    }
    return null;
}