//}}}
//{{{ Private members
//{{{ createEncodingErrorMessage() method
private static String getWriteEncodingErrorMessage(String encodingName, Encoding encoding, Segment line, int lineIndex) {
    String args[] = { encodingName, Integer.toString(lineIndex + 1), // column
    "UNKNOWN", // the character
    "UNKNOWN" };
    try {
        int charIndex = getFirstGuiltyCharacterIndex(encoding, line);
        if (0 <= charIndex && charIndex < line.count) {
            char c = line.array[line.offset + charIndex];
            args[2] = Integer.toString(charIndex + 1);
            args[3] = "'" + c + "' (U+" + Integer.toHexString(c).toUpperCase() + ")";
        }
    } catch (Exception e) {
    }
    return jEdit.getProperty("ioerror.write-encoding-error", args);
}