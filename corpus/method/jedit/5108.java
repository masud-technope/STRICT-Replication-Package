private static String replaceNonPathChars(String path, String replaceWith) {
    if (path == null)
        return null;
    String sForeignChars = ":*?\"<>|";
    StringBuilder sbForeignCharsEsc = new StringBuilder(20);
    for (int i = 0; i < sForeignChars.length(); i++) {
        sbForeignCharsEsc.append("\\");
        sbForeignCharsEsc.append(sForeignChars.charAt(i));
    }
    return path.replaceAll("[" + sbForeignCharsEsc + "]", replaceWith);
}