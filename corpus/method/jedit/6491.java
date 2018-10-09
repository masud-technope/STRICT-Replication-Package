//}}}
//{{{ createRegexpEOLSpanRule() method
public static ParserRule createRegexpEOLSpanRule(int posMatch, char[] hashChars, String seq, ParserRuleSet delegate, byte id, byte matchType, boolean ignoreCase) throws PatternSyntaxException {
    int ruleAction = EOL_SPAN | REGEXP | NO_LINE_BREAK;
    return new ParserRule(hashChars, ruleAction, posMatch, null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)), 0, null, null, delegate, id, matchType, null);
}