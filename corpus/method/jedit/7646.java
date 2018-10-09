public static int getLeadingWhiteSpace(CharSequence str) {
    int whitespace = 0;
    loop: for (; whitespace < str.length(); ) {
        switch(str.charAt(whitespace)) {
            case ' ':
            case '\t':
                whitespace++;
                break;
            default:
                break loop;
        }
    }
    return whitespace;
}