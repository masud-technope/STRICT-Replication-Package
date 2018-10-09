//{{{ Expansion constructor
 Expansion(String text, int softTabSize, List<String> pp) {
    StringBuilder buf = new StringBuilder();
    boolean backslash = false;
    for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        //{{{ Handle backslash
        if (backslash) {
            backslash = false;
            if (ch == '|')
                caretPosition = buf.length();
            else if (ch == 'n') {
                buf.append('\n');
                lineCount++;
            } else if (ch == 't') {
                if (softTabSize == 0)
                    buf.append('\t');
                else {
                    for (int j = 0; j < softTabSize; j++) buf.append(' ');
                }
            } else
                buf.append(ch);
        } else if (ch == '\\')
            backslash = true;
        else if (ch == '$') {
            if (i != text.length() - 1) {
                ch = text.charAt(i + 1);
                if (Character.isDigit(ch) && ch != '0') {
                    i++;
                    int pos = ch - '0';
                    posParamCount = Math.max(pos, posParamCount);
                    if (pos <= pp.size())
                        buf.append(pp.get(pos - 1));
                } else {
                    buf.append('$');
                }
            } else
                buf.append('$');
        } else
            buf.append(ch);
    }
    this.text = buf.toString();
}