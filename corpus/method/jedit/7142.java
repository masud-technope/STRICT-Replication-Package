//}}}
//{{{ selectToMatchingBracket() method
/**
	 * Selects from the bracket at the specified position to the
	 * corresponding bracket.
	 * @since jEdit 4.2pre1
	 */
public Selection selectToMatchingBracket(int position, boolean quickCopy) {
    int positionLine = buffer.getLineOfOffset(position);
    int lineOffset = position - buffer.getLineStartOffset(positionLine);
    if (getLineLength(positionLine) != 0) {
        int bracket = TextUtilities.findMatchingBracket(buffer, positionLine, Math.max(0, lineOffset - 1));
        if (bracket != -1) {
            Selection s;
            if (bracket < position) {
                if (!quickCopy)
                    moveCaretPosition(position, false);
                s = new Selection.Range(bracket, position);
            } else {
                if (!quickCopy)
                    moveCaretPosition(bracket + 1, false);
                s = new Selection.Range(position - 1, bracket + 1);
            }
            if (!multi && !quickCopy)
                selectNone();
            addToSelection(s);
            return s;
        }
    }
    return null;
}