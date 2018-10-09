//}}}
//{{{ addExplicitFold() method
/**
	 * Add an explicit fold.
	 * You should call this method inside a compoundEdit in the buffer.
	 * You must also check if the buffer fold mode is explicit before
	 * calling this method.
	 *
	 * @param caretStart the starting offset
	 * @param caretEnd   the end offset
	 * @param lineStart  the start line
	 * @param lineEnd    the end line
	 * @since jEdit 4.3pre3
	 */
protected int addExplicitFold(int caretStart, int caretEnd, int lineStart, int lineEnd) {
    // need to "fix" the caret position so that we get the right rule.
    // taking the start offset one char ahead and the end offset one char
    // behing makes sure we get the right rule for the text being
    // wrapped (tricky around mode boundaries, e.g., php code embedded
    // in HTML code)
    int startCaret = caretStart < buffer.getLength() ? caretStart + 1 : caretStart;
    int endCaret = caretEnd > 0 ? caretEnd - 1 : caretEnd;
    String startLineComment = buffer.getContextSensitiveProperty(startCaret, "lineComment");
    String startCommentStart = buffer.getContextSensitiveProperty(startCaret, "commentStart");
    String startCommentEnd = buffer.getContextSensitiveProperty(startCaret, "commentEnd");
    String endLineComment = buffer.getContextSensitiveProperty(endCaret, "lineComment");
    String endCommentStart = buffer.getContextSensitiveProperty(endCaret, "commentStart");
    String endCommentEnd = buffer.getContextSensitiveProperty(endCaret, "commentEnd");
    String start;
    int caretBack = 1;
    if (startLineComment != null)
        start = startLineComment + "{{{ ";
    else if (startCommentStart != null && startCommentEnd != null) {
        start = startCommentStart + "{{{  " + startCommentEnd;
        caretBack = 2 + startCommentEnd.length();
    } else
        start = "{{{ ";
    if (startLineComment != null) {
        // we're inserting
        if (buffer.getLineLength(lineStart) != caretStart) {
            start += '\n';
        }
    } else {
        // always insert a new line if there's no comment character.
        start += "\n";
    }
    String end;
    if (endLineComment != null)
        end = endLineComment + "}}}";
    else if (endCommentStart != null && endCommentEnd != null)
        end = endCommentStart + "}}}" + endCommentEnd;
    else
        end = "}}}";
    String line = buffer.getLineText(lineStart);
    String whitespace = line.substring(0, StandardUtilities.getLeadingWhiteSpace(line));
    caretBack += whitespace.length();
    if (caretStart == caretEnd) {
        caretBack += end.length() + 1;
        int lineStartOffset = buffer.getLineStartOffset(lineStart);
        if (lineStartOffset + whitespace.length() != caretStart) {
            caretBack++;
        }
    }
    if (endLineComment != null) {
        // comment out existing code.
        if (buffer.getLineLength(lineEnd) != caretEnd) {
            end += '\n';
        }
    } else {
        // always insert a new line if there's no comment character.
        end += "\n";
    }
    if (caretEnd == buffer.getLineStartOffset(lineEnd))
        buffer.insert(caretEnd, end);
    else {
        CharSequence lineText = buffer.getSegment(caretEnd - 1, 1);
        if (Character.isWhitespace(lineText.charAt(0)))
            buffer.insert(caretEnd, end);
        else
            buffer.insert(caretEnd, ' ' + end);
    }
    buffer.insert(caretStart, start + whitespace);
    return caretBack;
}