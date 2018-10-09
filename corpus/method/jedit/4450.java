//}}}
//{{{ apply() method
public void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions) {
    if (prevLineIndex == -1)
        return;
    int lineIndex = prevLineIndex;
    int oldLineIndex = lineIndex;
    CharSequence lineText = buffer.getLineSegment(lineIndex);
    int searchPos = -1;
    while (true) {
        if (lineIndex != oldLineIndex) {
            lineText = buffer.getLineSegment(lineIndex);
            oldLineIndex = lineIndex;
        }
        Parens parens = new Parens(buffer, lineIndex, searchPos);
        // No unmatched parens on prev line.
        if (parens.openOffset == -1 && parens.closeOffset == -1) {
            // Try prev-prev line if present.
            if (prevPrevLineIndex != -1) {
                searchPos = -1;
                lineIndex = prevPrevLineIndex;
                prevPrevLineIndex = -1;
                continue;
            }
            return;
        }
        // align according to its position.
        if (parens.closeOffset == -1) {
            // recalculate column (when using tabs instead of spaces)
            int indent = parens.openOffset + getIndent(lineText, buffer.getTabSize()) - lineText.length();
            indentActions.clear();
            indentActions.add(new IndentAction.AlignParameter(indent));
            return;
        }
        // There's an unmatched closed parenthesis - find the
        // matching parenthesis and start looking from there again.
        int openParenOffset = TextUtilities.findMatchingBracket(buffer, lineIndex, parens.closeOffset);
        if (openParenOffset >= 0) {
            // Avoid falling back to the prev-prev line in this case.
            prevPrevLineIndex = -1;
            lineIndex = buffer.getLineOfOffset(openParenOffset);
            searchPos = openParenOffset - buffer.getLineStartOffset(lineIndex) - 1;
            if (searchPos < 0)
                break;
        } else
            break;
    }
}