//}}}
//{{{ createEscapeRule() method
public static ParserRule createEscapeRule(String seq) {
    int ruleAction = IS_ESCAPE;
    return new ParserRule(ruleAction, seq.substring(0, 1), 0, seq.toCharArray(), null, 0, null, null, null, Token.NULL, MATCH_TYPE_CONTEXT, null);
}