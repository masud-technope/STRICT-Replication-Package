//}}}
//{{{ getCompletions() method
private static void getCompletions(Buffer buffer, String word, KeywordMap keywordMap, String noWordSep, int caret, Set<Completion> completions) {
    int wordLen = word.length();
    //{{{ try to find matching keywords
    if (keywordMap != null) {
        String[] keywords = keywordMap.getKeywords();
        for (String _keyword : keywords) {
            if (_keyword.regionMatches(keywordMap.getIgnoreCase(), 0, word, 0, wordLen)) {
                Completion keyword = new Completion(_keyword, true);
                if (!completions.contains(keyword))
                    completions.add(keyword);
            }
        }
    //}}}
    }
    //{{{ loop through all lines of current buffer
    for (int i = 0; i < buffer.getLineCount(); i++) {
        CharSequence line = buffer.getLineSegment(i);
        int start = buffer.getLineStartOffset(i);
        if (StandardUtilities.startsWith(line, word) && caret != start + word.length()) {
            String _word = completeWord(line, 0, noWordSep);
            Completion comp = new Completion(_word, false);
            // remove duplicates
            if (!completions.contains(comp)) {
                completions.add(comp);
            }
        }
        // check for match inside line
        int len = line.length() - word.length();
        for (int j = 0; j < len; j++) {
            char c = line.charAt(j);
            if (!Character.isLetterOrDigit(c) && noWordSep.indexOf(c) == -1) {
                if (StandardUtilities.regionMatches(line, j + 1, word, 0, wordLen) && caret != start + j + word.length() + 1) {
                    String _word = completeWord(line, j + 1, noWordSep);
                    Completion comp = new Completion(_word, false);
                    // remove duplicates
                    if (!completions.contains(comp)) {
                        completions.add(comp);
                    }
                }
            }
        }
    //}}}
    }
}