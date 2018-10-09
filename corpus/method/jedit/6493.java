//}}}
//{{{ createEOLSpanRule() method
public static ParserRule createEOLSpanRule(int posMatch, String seq, ParserRuleSet delegate, byte id, byte matchType) {
    int ruleAction = EOL_SPAN | NO_LINE_BREAK;
    return new ParserRule(ruleAction, seq.substring(0, 1), posMatch, seq.toCharArray(), null, 0, null, null, delegate, id, matchType, null);
}