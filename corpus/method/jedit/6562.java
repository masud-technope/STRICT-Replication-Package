//}}}
//{{{ checkDelegateEnd() method
private boolean checkDelegateEnd(ParserRule rule) {
    if (rule.end == null && rule.endRegexp == null)
        return false;
    LineContext tempContext = context;
    context = context.parent;
    keywords = context.rules.getKeywords();
    boolean handled = handleRuleEnd(rule);
    context = tempContext;
    keywords = context.rules.getKeywords();
    if (handled) {
        if (context.inRule != null)
            handleRuleEnd(context.inRule);
        markKeyword(true);
        context = (LineContext) context.parent.clone();
        tokenHandler.handleToken(line, matchToken(context.inRule, context.inRule, context), pos - line.offset, pattern.count, context);
        keywords = context.rules.getKeywords();
        context.setInRule(null);
        lastOffset = pos + pattern.count;
        // move pos to last character of match sequence
        pos += pattern.count - 1;
        return true;
    }
    return false;
}