//}}}
//{{{ match() method
/**
	 *  a good introduction to the Boyer-Moore fast string matching
	 *  algorithm may be found on Moore's website at:
	 *
	 *   http://www.cs.utexas.edu/users/moore/best-ideas/string-searching/
	 * @throws InterruptedException 
	 *
	 * @since jEdit 4.3pre5
	 */
public int match(CharSequence text, boolean reverse) throws InterruptedException {
    if (Thread.interrupted())
        throw new InterruptedException();
    //{{{
    // lazily create skip and suffix arrays for either the
    // search pattern, or the reversed search pattern
    int[] skip, suffix;
    if (reverse) {
        if (back_skip == null) {
            back_skip = generateSkipArray(true);
            back_suffix = generateSuffixArray(true);
        }
        skip = back_skip;
        suffix = back_suffix;
    } else {
        if (fwd_skip == null) {
            fwd_skip = generateSkipArray(false);
            fwd_suffix = generateSuffixArray(false);
        }
        skip = fwd_skip;
        suffix = fwd_suffix;
    //}}}
    }
    // position variable for pattern test position
    int pos;
    // position variable for pattern start
    int anchor = 0;
    // last possible start position of a match with this pattern;
    // this is negative if the pattern is longer than the text
    // causing the search loop below to immediately fail
    //int last_anchor = reverseSearch
    //	? offset + pattern.length - 1
    //	: length - pattern.length;
    char ch = 0;
    int bad_char;
    int good_suffix;
    // without missing any potential pattern matches.
    SEARCH: while (anchor + pattern_end < text.length()) {
        if (Thread.interrupted())
            throw new InterruptedException();
        for (pos = pattern_end; pos >= 0; --pos) {
            ch = text.charAt(pos + anchor);
            if (ignoreCase)
                ch = Character.toUpperCase(ch);
            // pattern test
            if ((reverse ? ch != pattern[pattern_end - pos] : ch != pattern[pos])) {
                // character mismatch, determine how many characters to skip
                // heuristic #1
                bad_char = pos - skip[getSkipIndex(ch)];
                // heuristic #2
                good_suffix = suffix[pos];
                // skip the greater of the two distances provided by the
                // heuristics
                int skip_index = (bad_char > good_suffix) ? bad_char : good_suffix;
                anchor += skip_index;
                // go back to the while loop
                continue SEARCH;
            }
        }
        // MATCH: return the position of its first character
        return anchor;
    }
    // MISMATCH: return -1 as defined by API
    return -1;
}