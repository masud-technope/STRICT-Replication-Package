//}}}
//{{{ createSequenceRule() method
public static ParserRule createSequenceRule(int posMatch, String seq, ParserRuleSet delegate, byte id) {
    return new ParserRule(SEQ, seq.substring(0, 1), posMatch, seq.toCharArray(), null, 0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
}