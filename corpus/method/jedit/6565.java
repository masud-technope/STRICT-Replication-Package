//}}}
//{{{ offsetMatches
/**
	 * Checks if the offset matches given position-match-hint of
	 * ParserRule.
	 */
private boolean offsetMatches(int offset, int posMatch) {
    if ((posMatch & ParserRule.AT_LINE_START) == ParserRule.AT_LINE_START) {
        if (offset != line.offset) {
            return false;
        }
    } else if ((posMatch & ParserRule.AT_WHITESPACE_END) == ParserRule.AT_WHITESPACE_END) {
        if (offset != whitespaceEnd) {
            return false;
        }
    } else if ((posMatch & ParserRule.AT_WORD_START) == ParserRule.AT_WORD_START) {
        if (offset != lastOffset) {
            return false;
        }
    }
    return true;
}