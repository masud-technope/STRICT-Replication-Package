//}}}
//}}}
//{{{ Indentation
//{{{ removeTrailingWhiteSpace() method
/**
	 * Removes trailing whitespace from all lines in the specified list.
	 * @param lines The line numbers
	 * @since jEdit 3.2pre1
	 */
public void removeTrailingWhiteSpace(int[] lines) {
    try {
        beginCompoundEdit();
        for (int line : lines) {
            Segment seg = new Segment();
            getLineText(line, seg);
            // blank line
            if (seg.count == 0)
                continue;
            int lineStart = seg.offset;
            int lineEnd = seg.offset + seg.count - 1;
            int pos;
            for (pos = lineEnd; pos >= lineStart; pos--) {
                if (!Character.isWhitespace(seg.array[pos]))
                    break;
            }
            int tail = lineEnd - pos;
            // no whitespace
            if (tail == 0)
                continue;
            remove(getLineEndOffset(line) - 1 - tail, tail);
        }
    } finally {
        endCompoundEdit();
    }
}