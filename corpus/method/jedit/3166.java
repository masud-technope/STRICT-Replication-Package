//{{{ completeWord() method
public static void completeWord(View view) {
    JEditTextArea textArea = view.getTextArea();
    Buffer buffer = view.getBuffer();
    int caretLine = textArea.getCaretLine();
    int caret = textArea.getCaretPosition();
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    KeywordMap keywordMap = buffer.getKeywordMapAtOffset(caret);
    String noWordSep = getNonAlphaNumericWordChars(buffer, keywordMap);
    String word = getWordToComplete(buffer, caretLine, caret, noWordSep);
    if (word == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Completion[] completions = getCompletions(buffer, word, caret);
    if (completions.length == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    } else //{{{ if there is only one competion, insert in buffer
    if (completions.length == 1) {
        Completion c = completions[0];
        if (c.text.equals(word)) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        } else {
            textArea.replaceSelection(c.text.substring(word.length()));
        }
    //}}}
    } else //{{{ show popup if > 1
    {
        String longestPrefix = MiscUtilities.getLongestPrefix(completions, keywordMap != null && keywordMap.getIgnoreCase());
        if (word.length() < longestPrefix.length()) {
            buffer.insert(caret, longestPrefix.substring(word.length()));
        }
        textArea.scrollToCaret(false);
        Point location = textArea.offsetToXY(caret - word.length());
        location.y += textArea.getPainter().getLineHeight();
        SwingUtilities.convertPointToScreen(location, textArea.getPainter());
        new CompleteWord(view, longestPrefix, completions, location, noWordSep);
    //}}}
    }
}