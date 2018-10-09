public static int getLeadingWhiteSpaceWidth(CharSequence str, int tabSize) {
    int whitespace = 0;
    loop: for (int i = 0; i < str.length(); i++) {
        switch(str.charAt(i)) {
            case ' ':
                whitespace++;
                break;
            case '\t':
                whitespace += tabSize - whitespace % tabSize;
                break;
            default:
                break loop;
        }
    }
    return whitespace;
}