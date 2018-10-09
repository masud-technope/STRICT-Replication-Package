//}}}
//{{{ getCompletions() method
private static Completion[] getCompletions(final Buffer buffer, final String word, final int caret) {
    // build a list of unique words in all buffers, or visible buffers,
    // depending on completeFromAllBuffers
    final Set<Completion> completions = new TreeSet<Completion>(new StandardUtilities.StringCompare<Completion>());
    // only complete current buffer's keyword map
    final KeywordMap keywordMap = buffer.getKeywordMapAtOffset(caret);
    final String noWordSep = getNonAlphaNumericWordChars(buffer, keywordMap);
    final Collection<Buffer> sourceBuffers = jEdit.getBooleanProperty("completeFromAllBuffers") ? Arrays.asList(jEdit.getBuffers()) : getVisibleBuffers();
    for (Buffer b : sourceBuffers) {
        // only complete current buffer's keyword map
        KeywordMap _keywordMap;
        if (b == buffer)
            _keywordMap = keywordMap;
        else
            _keywordMap = null;
        int offset = (b == buffer ? caret : 0);
        getCompletions(b, word, keywordMap, noWordSep, offset, completions);
    }
    Completion[] completionArray = completions.toArray(new Completion[completions.size()]);
    return completionArray;
}