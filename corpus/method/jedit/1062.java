public void charSetup(String str) {
    char ch = str.charAt(0);
    if (ch == '\\') {
        ch = str.charAt(1);
        if (Character.isDigit(ch))
            ch = (char) Integer.parseInt(str.substring(1), 8);
        else
            ch = getEscapeChar(ch);
    }
    value = new Primitive(ch);
}