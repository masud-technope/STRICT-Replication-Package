//}}}
//{{{ createRegexpSequenceRule() method
public static ParserRule createRegexpSequenceRule(int posMatch, char[] hashChars, String seq, ParserRuleSet delegate, byte id, boolean ignoreCase) throws PatternSyntaxException {
    return new ParserRule(hashChars, SEQ | REGEXP, posMatch, null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)), 0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
}