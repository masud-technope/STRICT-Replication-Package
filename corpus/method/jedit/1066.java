void stringSetup(String str) {
    StringBuilder buffer = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (ch == '\\') {
            ch = str.charAt(++i);
            if (Character.isDigit(ch)) {
                int endPos = i;
                while (endPos < i + 2) {
                    if (Character.isDigit(str.charAt(endPos + 1)))
                        endPos++;
                    else
                        break;
                }
                ch = (char) Integer.parseInt(str.substring(i, endPos + 1), 8);
                i = endPos;
            } else
                ch = getEscapeChar(ch);
        }
        buffer.append(ch);
    }
    value = buffer.toString().intern();
}