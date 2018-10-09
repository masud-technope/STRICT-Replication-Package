//}}}
//{{{ doWordWrap() method
/**
	 * Does hard wrap.
	 */
protected boolean doWordWrap(boolean spaceInserted) {
    if (!hardWrap || maxLineLen <= 0)
        return false;
    final Segment lineSegment = new Segment();
    buffer.getLineText(caretLine, lineSegment);
    int start = getLineStartOffset(caretLine);
    int end = getLineEndOffset(caretLine);
    int len = end - start - 1;
    int caretPos = caret - start;
    // line text is whitespace
    for (int i = caretPos; i < len; i++) {
        char ch = lineSegment.array[lineSegment.offset + i];
        if (ch != ' ' && ch != '\t')
            return false;
    }
    int tabSize = buffer.getTabSize();
    String wordBreakChars = buffer.getStringProperty("wordBreakChars");
    // last character before wrap
    int lastInLine = 0;
    // length with tabs expanded
    int logicalLength = 0;
    int lastWordOffset = -1;
    boolean lastWasSpace = true;
    for (int i = 0; i < caretPos; i++) {
        char ch = lineSegment.array[lineSegment.offset + i];
        if (ch == '\t') {
            logicalLength += tabSize - (logicalLength % tabSize);
            if (!lastWasSpace && logicalLength <= maxLineLen) {
                lastInLine = i;
                lastWordOffset = i;
                lastWasSpace = true;
            }
        } else if (ch == ' ') {
            logicalLength++;
            if (!lastWasSpace && logicalLength <= maxLineLen + 1) {
                lastInLine = i;
                lastWordOffset = i;
                lastWasSpace = true;
            }
        } else if (wordBreakChars != null && wordBreakChars.indexOf(ch) != -1) {
            logicalLength++;
            if (!lastWasSpace && logicalLength <= maxLineLen) {
                lastInLine = i;
                lastWordOffset = i;
                lastWasSpace = true;
            }
        } else {
            lastInLine = i;
            logicalLength++;
            lastWasSpace = false;
        }
    }
    boolean returnValue;
    int insertNewLineAt;
    if (spaceInserted && logicalLength == maxLineLen && lastInLine == caretPos - 1) {
        insertNewLineAt = caretPos;
        returnValue = true;
    } else if (logicalLength >= maxLineLen && lastWordOffset != -1) {
        insertNewLineAt = lastWordOffset;
        returnValue = false;
    } else
        return false;
    String indent = buffer.getStringProperty("autoIndent");
    try {
        buffer.beginCompoundEdit();
        buffer.insert(start + insertNewLineAt, "\n");
        // since insertNewLineAt <= caretPos
        if ("full".equals(indent))
            buffer.indentLine(caretLine, true);
        else if ("simple".equals(indent))
            buffer.simpleIndentLine(caretLine);
    } finally {
        buffer.endCompoundEdit();
    }
    /* only ever return true if space was pressed
		 * with logicalLength == maxLineLen */
    return returnValue;
}