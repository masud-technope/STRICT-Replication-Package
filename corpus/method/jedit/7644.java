public static int getTrailingWhiteSpace(String str) {
    int whitespace = 0;
    loop: for (int i = str.length() - 1; i >= 0; i--) {
        switch(str.charAt(i)) {
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