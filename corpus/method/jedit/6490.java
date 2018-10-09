//}}}
//{{{ createRegexpEOLSpanRule() method
public static ParserRule createRegexpEOLSpanRule(String hashChar, int posMatch, String seq, ParserRuleSet delegate, byte id, byte matchType, boolean ignoreCase) throws PatternSyntaxException {
    int ruleAction = EOL_SPAN | REGEXP | NO_LINE_BREAK;
    return new ParserRule(ruleAction, hashChar, posMatch, null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)), 0, null, null, delegate, id, matchType, null);
}