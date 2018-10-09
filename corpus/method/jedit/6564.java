//}}}
//{{{ handleRuleStart() method
/**
	 * Checks if the rule matches the line at the current position
	 * as its start and handles the rule if it does match
	 */
private boolean handleRuleStart(ParserRule checkRule) {
    // Some rules can only match in certain locations
    if (null == checkRule.upHashChars) {
        if (checkRule.upHashChar != null && (pos + checkRule.upHashChar.length < line.array.length) && !checkHashString(checkRule)) {
            return false;
        }
    } else {
        if (-1 == Arrays.binarySearch(checkRule.upHashChars, Character.toUpperCase(line.array[pos]))) {
            return false;
        }
    }
    int offset = (checkRule.action & ParserRule.MARK_PREVIOUS) != 0 ? lastOffset : pos;
    if (!offsetMatches(offset, checkRule.startPosMatch)) {
        return false;
    }
    int matchedChars;
    Matcher match = null;
    // See if the rule's start sequence matches here
    if ((checkRule.action & ParserRule.REGEXP) == 0) {
        pattern.array = checkRule.start;
        pattern.offset = 0;
        pattern.count = pattern.array.length;
        matchedChars = pattern.count;
        if (!SyntaxUtilities.regionMatches(context.rules.getIgnoreCase(), line, pos, pattern.array)) {
            return false;
        }
    } else {
        // note that all regexps start with \A so they only
        // match the start of the string
        //int matchStart = pos - line.offset;
        CharSequence charSeq = new SegmentCharSequence(line, pos - line.offset, line.count - (pos - line.offset));
        match = checkRule.startRegexp.matcher(charSeq);
        if (!match.lookingAt()) {
            return false;
        } else if (match.start() != 0) {
            throw new InternalError("Can't happen");
        } else {
            matchedChars = match.end();
            /* workaround for hang if match was
				 * zero-width. not sure if there is
				 * a better way to handle this */
            if (matchedChars == 0)
                matchedChars = 1;
        }
    }
    if ((checkRule.action & ParserRule.IS_ESCAPE) == ParserRule.IS_ESCAPE) {
        pos += pattern.count;
    } else {
        if (context.inRule != null)
            handleRuleEnd(context.inRule);
        markKeyword((checkRule.action & ParserRule.MARK_PREVIOUS) != ParserRule.MARK_PREVIOUS);
        switch(checkRule.action & ParserRule.MAJOR_ACTIONS) {
            //{{{ SEQ
            case ParserRule.SEQ:
                context.spanEndSubst = null;
                context.spanEndSubstRegex = null;
                if ((checkRule.action & ParserRule.REGEXP) != 0) {
                    handleTokenWithSpaces(tokenHandler, checkRule.token, pos - line.offset, matchedChars, context);
                } else {
                    tokenHandler.handleToken(line, checkRule.token, pos - line.offset, matchedChars, context);
                }
                // ruleset from the end of the SEQ onwards
                if (checkRule.delegate != null) {
                    context = new LineContext(checkRule.delegate, context.parent);
                    keywords = context.rules.getKeywords();
                }
                break;
            //{{{ SPAN, EOL_SPAN
            case ParserRule.SPAN:
            case ParserRule.EOL_SPAN:
                context.setInRule(checkRule);
                byte tokenType = matchToken(checkRule, context.inRule, context);
                if ((checkRule.action & ParserRule.REGEXP) != 0) {
                    handleTokenWithSpaces(tokenHandler, tokenType, pos - line.offset, matchedChars, context);
                } else {
                    tokenHandler.handleToken(line, tokenType, pos - line.offset, matchedChars, context);
                }
                char[] spanEndSubst = null;
                Pattern spanEndSubstRegex = null;
                /* substitute result of matching the rule start
				 * into the end string.
				 *
				 * eg, in shell script mode, <<\s*(\w+) is
				 * matched into \<$1\> to construct rules for
				 * highlighting read-ins like this <<EOF
				 * ...
				 * EOF
				 */
                if (match != null && match.groupCount() > 0) {
                    if (checkRule.end != null) {
                        spanEndSubst = substitute(match, checkRule.end, false);
                    } else if (checkRule.endRegexp != null) {
                        char[] pattern = checkRule.endRegexp.pattern().toCharArray();
                        pattern = substitute(match, pattern, true);
                        spanEndSubstRegex = Pattern.compile(new String(pattern));
                    }
                }
                context.spanEndSubst = spanEndSubst;
                context.spanEndSubstRegex = spanEndSubstRegex;
                context = new LineContext(checkRule.delegate, context);
                keywords = context.rules.getKeywords();
                break;
            //{{{ MARK_FOLLOWING
            case ParserRule.MARK_FOLLOWING:
                tokenHandler.handleToken(line, matchToken(checkRule, checkRule, context), pos - line.offset, pattern.count, context);
                context.spanEndSubst = null;
                context.spanEndSubstRegex = null;
                context.setInRule(checkRule);
                break;
            //{{{ MARK_PREVIOUS
            case ParserRule.MARK_PREVIOUS:
                context.spanEndSubst = null;
                context.spanEndSubstRegex = null;
                if (pos != lastOffset) {
                    tokenHandler.handleToken(line, checkRule.token, lastOffset - line.offset, pos - lastOffset, context);
                }
                tokenHandler.handleToken(line, matchToken(checkRule, checkRule, context), pos - line.offset, pattern.count, context);
                break;
            //}}}
            default:
                throw new InternalError("Unhandled major action");
        }
        // move pos to last character of match sequence
        pos += matchedChars - 1;
        lastOffset = pos + 1;
    // break out of inner for loop to check next char
    }
    return true;
}