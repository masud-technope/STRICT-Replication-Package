//}}}
//{{{ createSpanRule() method
public static ParserRule createSpanRule(int startPosMatch, String start, int endPosMatch, String end, ParserRuleSet delegate, byte id, byte matchType, boolean noLineBreak, boolean noWordBreak, String escape) {
    int ruleAction = SPAN | ((noLineBreak) ? NO_LINE_BREAK : 0) | ((noWordBreak) ? NO_WORD_BREAK : 0);
    return new ParserRule(ruleAction, start.substring(0, 1), startPosMatch, start.toCharArray(), null, endPosMatch, end.toCharArray(), null, delegate, id, matchType, escape);
}