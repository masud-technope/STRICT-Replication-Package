private void writeKeyBooleanPair(String key, Boolean b, Node appendTo) {
    if (b == null) {
        return;
    }
    writeKey(key, appendTo);
    writeBoolean(b, appendTo);
}