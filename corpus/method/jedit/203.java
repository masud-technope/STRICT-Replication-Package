private void writeKeyStringPair(String key, String string, Node appendTo) {
    if (string == null) {
        return;
    }
    writeKey(key, appendTo);
    writeString(string, appendTo);
}