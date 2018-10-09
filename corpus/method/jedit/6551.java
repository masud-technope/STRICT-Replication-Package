//}}}
//{{{ matchToken() method
private byte matchToken(ParserRule rule, ParserRule base, LineContext ctx) {
    switch(rule.matchType) {
        case ParserRule.MATCH_TYPE_RULE:
            return base.token;
        case ParserRule.MATCH_TYPE_CONTEXT:
            return context.rules.getDefault();
        default:
            return rule.matchType;
    }
}