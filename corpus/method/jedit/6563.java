//}}}
//{{{ markTokens() method
/**
	 * Do not call this method directly; call Buffer.markTokens() instead.
	 *
	 * @param prevContext the context of the previous line, it can be null
	 * @param tokenHandler the token handler
	 * @param line a segment containing the content of the line
	 */
public synchronized LineContext markTokens(LineContext prevContext, TokenHandler tokenHandler, Segment line) {
    //{{{ Set up some instance variables
    // this is to avoid having to pass around lots and lots of
    // parameters.
    this.tokenHandler = tokenHandler;
    this.line = line;
    lastOffset = line.offset;
    lineLength = line.count + line.offset;
    context = new LineContext();
    if (prevContext == null) {
        context.rules = getMainRuleSet();
        context.escapeRule = context.rules.getEscapeRule();
    } else {
        context.parent = prevContext.parent;
        context.setInRule(prevContext.inRule);
        context.rules = prevContext.rules;
        context.spanEndSubst = prevContext.spanEndSubst;
        context.spanEndSubstRegex = prevContext.spanEndSubstRegex;
    }
    keywords = context.rules.getKeywords();
    seenWhitespaceEnd = false;
    whitespaceEnd = line.offset;
    //}}}
    //{{{ Main parser loop
    int terminateChar = context.rules.getTerminateChar();
    boolean terminated = false;
    main_loop: for (pos = line.offset; pos < lineLength; pos++) {
        //{{{ check if we have to stop parsing (happens if the terminateChar has been exceeded)
        if (terminateChar >= 0 && pos - line.offset >= terminateChar && !terminated) {
            terminated = true;
            context = new LineContext(ParserRuleSet.getStandardRuleSet(context.rules.getDefault()), context);
            keywords = context.rules.getKeywords();
        //}}}
        }
        //{{{ Check for the escape rule before anything else.
        if (context.escapeRule != null && handleRuleStart(context.escapeRule)) {
            continue main_loop;
        //}}}
        }
        //{{{ check for end of delegate
        if (context.parent != null && context.parent.inRule != null && checkDelegateEnd(context.parent.inRule)) {
            seenWhitespaceEnd = true;
            continue main_loop;
        //}}}
        }
        //{{{ check every rule
        Character ch = Character.valueOf(line.array[pos]);
        List<ParserRule> rules = context.rules.getRules(ch);
        for (ParserRule rule : rules) {
            // stop checking rules if there was a match
            if (handleRuleStart(rule)) {
                seenWhitespaceEnd = true;
                continue main_loop;
            }
        //}}}
        }
        //{{{ check if current character is a word separator
        if (Character.isWhitespace(ch)) {
            if (!seenWhitespaceEnd)
                whitespaceEnd = pos + 1;
            if (context.inRule != null)
                handleRuleEnd(context.inRule);
            handleNoWordBreak();
            markKeyword(false);
            if (lastOffset != pos) {
                tokenHandler.handleToken(line, context.rules.getDefault(), lastOffset - line.offset, pos - lastOffset, context);
            }
            tokenHandler.handleToken(line, context.rules.getDefault(), pos - line.offset, 1, context);
            lastOffset = pos + 1;
        } else {
            if (keywords != null || context.rules.getRuleCount() != 0) {
                String noWordSep = context.rules.getNoWordSep();
                if (!Character.isLetterOrDigit(ch) && noWordSep.indexOf(ch) == -1) {
                    if (context.inRule != null)
                        handleRuleEnd(context.inRule);
                    handleNoWordBreak();
                    markKeyword(true);
                    tokenHandler.handleToken(line, context.rules.getDefault(), lastOffset - line.offset, 1, context);
                    lastOffset = pos + 1;
                }
            }
            seenWhitespaceEnd = true;
        //}}}
        }
    //}}}
    }
    //{{{ Mark all remaining characters
    pos = lineLength;
    if (context.inRule != null)
        handleRuleEnd(context.inRule);
    handleNoWordBreak();
    markKeyword(true);
    //{{{ Unwind any NO_LINE_BREAK parent delegates
    unwind: while (context.parent != null) {
        ParserRule rule = context.parent.inRule;
        if ((rule != null && (rule.action & ParserRule.NO_LINE_BREAK) == ParserRule.NO_LINE_BREAK) || terminated) {
            context = context.parent;
            keywords = context.rules.getKeywords();
            context.setInRule(null);
        } else
            break unwind;
    //}}}
    }
    tokenHandler.handleToken(line, Token.END, pos - line.offset, 0, context);
    context = context.intern();
    tokenHandler.setLineContext(context);
    /* for GC. */
    this.tokenHandler = null;
    this.line = null;
    return context;
}