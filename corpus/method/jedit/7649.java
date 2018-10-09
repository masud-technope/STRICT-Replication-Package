public static String getIndentString(String str) {
    StringBuilder indentString = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (!Character.isWhitespace(ch))
            break;
        indentString.append(ch);
    }
    return indentString.toString();
}