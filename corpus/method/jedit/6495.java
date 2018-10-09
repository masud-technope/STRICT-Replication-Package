//}}}
//{{{ createRegexpSpanRule() method
public static ParserRule createRegexpSpanRule(String hashChar, int startPosMatch, String start, int endPosMatch, String end, ParserRuleSet delegate, byte id, byte matchType, boolean noLineBreak, boolean noWordBreak, boolean ignoreCase, String escape, boolean endRegexp) throws PatternSyntaxException {
    int ruleAction = SPAN | REGEXP | ((noLineBreak) ? NO_LINE_BREAK : 0) | ((noWordBreak) ? NO_WORD_BREAK : 0);
    Pattern endRegexpPattern;
    char[] endArray;
    if (endRegexp) {
        ruleAction |= END_REGEXP;
        endRegexpPattern = Pattern.compile(end, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0));
        endArray = null;
    } else {
        endRegexpPattern = null;
        endArray = end.toCharArray();
    }
    return new ParserRule(ruleAction, hashChar, startPosMatch, null, Pattern.compile(start, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)), endPosMatch, endArray, endRegexpPattern, delegate, id, matchType, escape);
}