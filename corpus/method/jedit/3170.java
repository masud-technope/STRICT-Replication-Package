//}}}
//{{{ getWordToComplete() method
private static String getWordToComplete(Buffer buffer, int caretLine, int caret, String noWordSep) {
    CharSequence line = buffer.getLineSegment(caretLine);
    int dot = caret - buffer.getLineStartOffset(caretLine);
    if (dot == 0)
        return null;
    char ch = line.charAt(dot - 1);
    if (!Character.isLetterOrDigit(ch) && noWordSep.indexOf(ch) == -1) {
        // attempting to expand non-word char
        return null;
    }
    int wordStart = TextUtilities.findWordStart(line, dot - 1, noWordSep);
    CharSequence word = line.subSequence(wordStart, dot);
    if (word.length() == 0)
        return null;
    return word.toString();
}