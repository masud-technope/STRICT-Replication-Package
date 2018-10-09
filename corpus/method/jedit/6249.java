@Override
public String toString() {
    boolean ignoreCase = (flags & Pattern.CASE_INSENSITIVE) != 0;
    return "PatternSearchMatcher[" + pattern + ',' + ignoreCase + ']';
}