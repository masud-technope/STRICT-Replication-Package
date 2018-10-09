//}}}
//{{{ createMarkFollowingRule() method
public static ParserRule createMarkFollowingRule(int posMatch, String seq, byte id, byte matchType) {
    int ruleAction = MARK_FOLLOWING;
    return new ParserRule(ruleAction, seq.substring(0, 1), posMatch, seq.toCharArray(), null, 0, null, null, null, id, matchType, null);
}