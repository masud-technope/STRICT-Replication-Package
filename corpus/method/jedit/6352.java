private boolean isEndWord(char current, char next) {
    int currentCharType = TextUtilities.getCharType(current, noWordSep);
    if (currentCharType != TextUtilities.WORD_CHAR)
        return true;
    int nextCharType = TextUtilities.getCharType(next, noWordSep);
    return nextCharType != TextUtilities.WORD_CHAR;
}