//}}}
//{{{ find() method
/**
	 * Finds the next instance of the search string in the specified
	 * buffer.
	 * @param view The view
	 * @param buffer The buffer
	 * @param start Location where to start the search
	 * @param firstTime See {@link SearchMatcher#nextMatch(CharSequence,boolean,boolean,boolean,boolean)}.
	 * @since jEdit 4.1pre7
	 */
public static boolean find(View view, Buffer buffer, int start, boolean firstTime, boolean reverse) throws Exception {
    EditBus.send(new PositionChanging(view.getEditPane()));
    SearchMatcher matcher = getSearchMatcher();
    if (matcher == null) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return false;
    }
    CharSequence text;
    boolean startOfLine;
    boolean endOfLine;
    if (reverse) {
        text = new ReverseCharSequence(buffer.getSegment(0, start));
        startOfLine = true;
        endOfLine = (buffer.getLineEndOffset(buffer.getLineOfOffset(start)) - 1 == start);
    } else {
        text = buffer.getSegment(start, buffer.getLength() - start);
        startOfLine = (buffer.getLineStartOffset(buffer.getLineOfOffset(start)) == start);
        endOfLine = true;
    }
    if (matcher.wholeWord) {
        String noWordSep = buffer.getStringProperty("noWordSep");
        matcher.setNoWordSep(noWordSep);
    }
    SearchMatcher.Match match = matcher.nextMatch(text, startOfLine, endOfLine, firstTime, reverse);
    if (match != null) {
        jEdit.commitTemporary(buffer);
        view.setBuffer(buffer);
        JEditTextArea textArea = view.getTextArea();
        if (reverse) {
            textArea.setSelection(new Selection.Range(start - match.end, start - match.start));
            // make sure end of match is visible
            textArea.scrollTo(start - match.start, false);
            textArea.moveCaretPosition(start - match.end);
        } else {
            textArea.setSelection(new Selection.Range(start + match.start, start + match.end));
            textArea.moveCaretPosition(start + match.end);
            // make sure start of match is visible
            textArea.scrollTo(start + match.start, false);
        }
        return true;
    } else
        return false;
}