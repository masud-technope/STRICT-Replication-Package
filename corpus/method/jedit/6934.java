//{{{ setText() method
@Override
int setText(JEditBuffer buffer, String text) {
    int startColumn = getStartColumn(buffer);
    int endColumn = getEndColumn(buffer);
    int tabSize = buffer.getTabSize();
    int maxWidth = 0;
    int totalLines = 0;
    /** This list will contains Strings and Integer. */
    List<Object> lines = new ArrayList<Object>();
    //{{{ Split the text into lines
    if (text != null) {
        int lastNewline = 0;
        int currentWidth = startColumn;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '\n') {
                totalLines++;
                lines.add(text.substring(lastNewline, i));
                lastNewline = i + 1;
                maxWidth = Math.max(maxWidth, currentWidth);
                lines.add(currentWidth);
                currentWidth = startColumn;
            } else if (ch == '\t')
                currentWidth += tabSize - (currentWidth % tabSize);
            else
                currentWidth++;
        }
        if (lastNewline != text.length()) {
            totalLines++;
            lines.add(text.substring(lastNewline));
            lines.add(currentWidth);
            maxWidth = Math.max(maxWidth, currentWidth);
        }
    //}}}
    }
    //{{{ Insert the lines into the buffer
    int endOffset = 0;
    int[] total = new int[1];
    int lastLine = Math.max(startLine + totalLines - 1, endLine);
    for (int i = startLine; i <= lastLine; i++) {
        if (i == buffer.getLineCount())
            buffer.insert(buffer.getLength(), "\n");
        int lineStart = buffer.getLineStartOffset(i);
        int lineLen = buffer.getLineLength(i);
        int rectStart = buffer.getOffsetOfVirtualColumn(i, startColumn, total);
        int startWhitespace;
        if (rectStart == -1) {
            startWhitespace = startColumn - total[0];
            rectStart = lineLen;
        } else
            startWhitespace = 0;
        int rectEnd = buffer.getOffsetOfVirtualColumn(i, endColumn, null);
        if (rectEnd == -1)
            rectEnd = lineLen;
        buffer.remove(rectStart + lineStart, rectEnd - rectStart);
        if (startWhitespace != 0) {
            buffer.insert(rectStart + lineStart, StandardUtilities.createWhiteSpace(startWhitespace, 0));
        }
        int endWhitespace;
        if (totalLines == 0) {
            if (rectEnd == lineLen)
                endWhitespace = 0;
            else
                endWhitespace = maxWidth - startColumn;
        } else {
            int index = 2 * ((i - startLine) % totalLines);
            String str = (String) lines.get(index);
            buffer.insert(rectStart + lineStart + startWhitespace, str);
            if (rectEnd == lineLen)
                endWhitespace = 0;
            else {
                endWhitespace = maxWidth - (Integer) lines.get(index + 1);
            }
            startWhitespace += str.length();
        }
        if (endWhitespace != 0) {
            buffer.insert(rectStart + lineStart + startWhitespace, StandardUtilities.createWhiteSpace(endWhitespace, 0));
        }
        endOffset = rectStart + lineStart + startWhitespace + endWhitespace;
    //}}}
    }
    //{{{ Move the caret down a line
    if (text == null || text.length() == 0)
        return end;
    else
        return endOffset;
//}}}
//}}}
}