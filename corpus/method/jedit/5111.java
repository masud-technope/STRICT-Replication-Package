private static boolean containsNullCharacter(Reader reader) throws IOException {
    int nbChars = jEdit.getIntegerProperty("vfs.binaryCheck.length", 100);
    int authorized = jEdit.getIntegerProperty("vfs.binaryCheck.count", 1);
    for (long i = 0L; i < nbChars; i++) {
        int c = reader.read();
        if (c == -1)
            return false;
        if (c == 0) {
            authorized--;
            if (authorized == 0)
                return true;
        }
    }
    return false;
}