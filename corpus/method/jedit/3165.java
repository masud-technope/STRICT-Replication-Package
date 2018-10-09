//}}}
//{{{ completeWord() method
private static String completeWord(CharSequence line, int offset, String noWordSep) {
    // '+ 1' so that findWordEnd() doesn't pick up the space at the start
    int wordEnd = TextUtilities.findWordEnd(line, offset + 1, noWordSep);
    return line.subSequence(offset, wordEnd).toString();
}