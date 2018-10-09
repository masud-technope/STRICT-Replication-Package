//}}}
//{{{ createMarkPreviousRule() method
public static ParserRule createMarkPreviousRule(int posMatch, String seq, byte id, byte matchType) {
    int ruleAction = MARK_PREVIOUS;
    return new ParserRule(ruleAction, seq.substring(0, 1), posMatch, seq.toCharArray(), null, 0, null, null, null, id, matchType, null);
}