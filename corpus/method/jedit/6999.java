public Match getMatch(TextArea textArea) {
    int offset = textArea.getCaretPosition() - textArea.getLineStartOffset(textArea.getCaretLine());
    if (offset != 0) {
        int bracketOffset = TextUtilities.findMatchingBracket(textArea.getBuffer(), textArea.getCaretLine(), offset - 1);
        if (bracketOffset != -1) {
            int bracketLine = textArea.getLineOfOffset(bracketOffset);
            return new Match(this, bracketLine, bracketOffset, bracketLine, bracketOffset + 1);
        }
    }
    return null;
}