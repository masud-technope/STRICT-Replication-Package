//}}}
//{{{ createRegexpSequenceRule() method
public static ParserRule createRegexpSequenceRule(String hashChar, int posMatch, String seq, ParserRuleSet delegate, byte id, boolean ignoreCase) throws PatternSyntaxException {
    return new ParserRule(SEQ | REGEXP, hashChar, posMatch, null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)), 0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
}