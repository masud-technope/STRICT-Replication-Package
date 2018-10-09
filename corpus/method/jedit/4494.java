//}}}
//{{{ lineMatches() method
private boolean lineMatches(JEditBuffer buffer, int lineIndex) {
    TokenFilter filter = new TokenFilter(buffer.getLineLength(lineIndex));
    buffer.markTokens(lineIndex, filter);
    return regexp.matcher(filter.result).matches();
}