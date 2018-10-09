//}}}
//{{{ doWordCount() method
@SuppressWarnings("fallthrough")
protected static void doWordCount(View view, String text) {
    char[] chars = text.toCharArray();
    int characters = chars.length;
    int words = 0;
    int lines = 1;
    boolean word = true;
    for (char aChar : chars) {
        switch(aChar) {
            case '\r':
            case '\n':
                lines++;
            case ' ':
            case '\t':
                word = true;
                break;
            default:
                if (word) {
                    words++;
                    word = false;
                }
                break;
        }
    }
    Object[] args = { characters, words, lines };
    GUIUtilities.message(view, "wordcount", args);
}