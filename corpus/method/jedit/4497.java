public void apply(JEditBuffer buffer, int thisLineIndex, int prevLineIndex, int prevPrevLineIndex, List<IndentAction> indentActions) {
    /* Don't apply this rule if the current line is empty. */
    CharSequence current = buffer.getLineSegment(thisLineIndex);
    boolean found = false;
    for (int i = 0; i < current.length(); i++) {
        if (!Character.isWhitespace(current.charAt(i))) {
            found = true;
            break;
        }
    }
    if (!found)
        return;
    /* Check if the previous line is empty. */
    if (prevLineIndex >= 0) {
        CharSequence previous = buffer.getLineSegment(prevLineIndex);
        for (int i = 0; i < previous.length(); i++) {
            if (!Character.isWhitespace(previous.charAt(i)))
                return;
        }
    }
    indentActions.add(new IndentAction.NoIncrease());
}