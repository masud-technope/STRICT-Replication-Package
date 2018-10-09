//}}}
//{{{ handleNoWordBreak() method
private void handleNoWordBreak() {
    if (context.parent != null) {
        ParserRule rule = context.parent.inRule;
        if (rule != null && (context.parent.inRule.action & ParserRule.NO_WORD_BREAK) != 0) {
            if (pos != lastOffset) {
                tokenHandler.handleToken(line, rule.token, lastOffset - line.offset, pos - lastOffset, context);
            }
            lastOffset = pos;
            context = context.parent;
            keywords = context.rules.getKeywords();
            context.setInRule(null);
        }
    }
}