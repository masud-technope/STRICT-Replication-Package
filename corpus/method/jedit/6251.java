//}}}
//{{{ nextMatch() method
/**
	 * {@inheritDoc}
	 * <p>Reverse regex search is done by searching from the beginning to
	 * just prior to the current match, so will be inefficient for large
	 * buffers.</p>
	 */
@Override
public SearchMatcher.Match nextMatch(CharSequence text, boolean start, boolean end, boolean firstTime, boolean reverse) {
    // (even for reverse searches) un-reverse the ReverseCharSequence.
    if (text instanceof ReverseCharSequence)
        text = ((ReverseCharSequence) text).baseSequence();
    if (re == null)
        re = Pattern.compile(pattern, flags);
    // if the pattern begins with "^", avoid spurious match at the
    // start of input sequence which is not a start of line.
    int matchStart = 0;
    if (!start && re.pattern().charAt(0) == '^') {
        Matcher sol = Pattern.compile("^", flags).matcher(text);
        // Ignore the first match since it is not a start of line.
        sol.find();
        // can't match.
        if (!sol.find())
            return null;
        // Skip the text to the second match, which can be the first
        // match for the real pattern.
        matchStart = sol.start();
    }
    Matcher match = re.matcher(text);
    if (!match.find(matchStart)) {
        // Check for special constructs, groups starting with (? are either pure, 
        // non-capturing groups that do not capture text and do not count towards 
        // the group total, or named-capturing group. Either way, need to remove
        // them and try again since they won't match because the selection doesn't
        // necessarily include the non-capturing part.
        Pattern p = removeNonCapturingGroups(re, flags);
        match = p.matcher(text);
        if (!match.matches())
            return null;
    }
    // search.
    if (!reverse && !firstTime && match.start() == 0 && match.end() == 0) {
        if (!match.find())
            return null;
    }
    Match previous = null;
    while (true) {
        // not expected as an EOL.
        if ((!end || (text.charAt(text.length() - 1) == '\n')) && match.end() == text.length() && pattern.charAt(pattern.length() - 1) == '$') {
            if (previous != null) {
                returnValue.start = previous.start;
                returnValue.end = previous.end;
                returnValue.substitutions = previous.substitutions;
                break;
            } else {
                return null;
            }
        }
        returnValue.substitutions = new String[match.groupCount() + 1];
        for (int i = 0; i < returnValue.substitutions.length; i++) {
            returnValue.substitutions[i] = match.group(i);
        }
        int _start = match.start();
        int _end = match.end();
        returnValue.start = _start;
        returnValue.end = _end;
        if (wholeWord && !isWholeWord(text, _start, _end)) {
            if (!match.find())
                return null;
            continue;
        }
        // we continue until no more matches are found
        if (!reverse || !match.find()) {
            // the end of text.
            if (reverse && !firstTime && returnValue.start == text.length() && returnValue.end == text.length()) {
                if (previous != null) {
                    returnValue.start = previous.start;
                    returnValue.end = previous.end;
                    returnValue.substitutions = previous.substitutions;
                } else {
                    return null;
                }
            }
            break;
        }
        // Save the result for reverse zero width match.
        if (previous == null) {
            previous = new Match();
        }
        previous.start = returnValue.start;
        previous.end = returnValue.end;
        previous.substitutions = returnValue.substitutions;
    }
    if (reverse) {
        // The caller assumes we are searching a reversed
        // CharSegment, so we need to reverse the indices
        // before returning
        int len = returnValue.end - returnValue.start;
        returnValue.start = text.length() - returnValue.end;
        returnValue.end = returnValue.start + len;
    }
    return returnValue;
}