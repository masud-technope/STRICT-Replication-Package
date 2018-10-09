//{{{ getParserRuleSet() method
protected ParserRuleSet getParserRuleSet(TokenMarker.LineContext context) {
    while (context != null) {
        if (!context.rules.isBuiltIn())
            return context.rules;
        context = context.parent;
    }
    return null;
}