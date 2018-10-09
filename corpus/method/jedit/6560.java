//}}}
//{{{ handleRuleEnd() method
/**
	 * Checks if the rule matches the line at the current position
	 * as its end and handles the rule if it does match
	 */
private boolean handleRuleEnd(ParserRule checkRule) {
    // Some rules can only match in certain locations
    int offset = (checkRule.action & ParserRule.MARK_PREVIOUS) != 0 ? lastOffset : pos;
    if (!offsetMatches(offset, checkRule.endPosMatch)) {
        return false;
    }
    // See if the rule's end sequence matches here
    if ((checkRule.action & ParserRule.MARK_FOLLOWING) == 0) {
        if ((checkRule.action & ParserRule.END_REGEXP) == 0) {
            if (context.spanEndSubst != null)
                pattern.array = context.spanEndSubst;
            else
                pattern.array = checkRule.end;
            pattern.offset = 0;
            pattern.count = pattern.array.length;
            if (!SyntaxUtilities.regionMatches(context.rules.getIgnoreCase(), line, pos, pattern.array)) {
                return false;
            }
        } else {
            CharSequence charSeq = new SegmentCharSequence(line, pos - line.offset, line.count - (pos - line.offset));
            Pattern regex;
            if (context.spanEndSubstRegex != null)
                regex = context.spanEndSubstRegex;
            else
                regex = checkRule.endRegexp;
            Matcher match = regex.matcher(charSeq);
            if (!match.lookingAt()) {
                return false;
            } else {
                // This is used in checkDelegateEnd
                pattern.count = match.end();
            }
        }
    }
    // Escape rules are handled in handleRuleStart()
    assert (checkRule.action & ParserRule.IS_ESCAPE) == 0;
    // Handle end of MARK_FOLLOWING
    if ((context.inRule.action & ParserRule.MARK_FOLLOWING) != 0) {
        if (pos != lastOffset) {
            tokenHandler.handleToken(line, context.inRule.token, lastOffset - line.offset, pos - lastOffset, context);
        }
        lastOffset = pos;
        context.setInRule(null);
    }
    return true;
}