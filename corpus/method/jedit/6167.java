//}}}
//{{{ doHyperSearch() method
private int doHyperSearch(Buffer buffer, int start, int end, DefaultMutableTreeNode bufferNode) {
    if (matcher.wholeWord) {
        buffer.setMode();
        String noWordSep = buffer.getStringProperty("noWordSep");
        matcher.setNoWordSep(noWordSep);
    }
    int resultCount = 0;
    JEditTextArea textArea = jEdit.getActiveView().getTextArea();
    int caretLine = textArea.getBuffer() == buffer ? textArea.getCaretLine() : -1;
    try {
        buffer.readLock();
        boolean endOfLine = buffer.getLineEndOffset(buffer.getLineOfOffset(end)) - 1 == end;
        int offset = start;
        HyperSearchResult lastResult = null;
        for (int counter = 0; ; counter++) {
            boolean startOfLine = buffer.getLineStartOffset(buffer.getLineOfOffset(offset)) == offset;
            SearchMatcher.Match match = null;
            try {
                match = matcher.nextMatch(buffer.getSegment(offset, end - offset), startOfLine, endOfLine, counter == 0, false);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (match == null)
                break;
            int newLine = buffer.getLineOfOffset(offset + match.start);
            if (lastResult == null || lastResult.line != newLine) {
                lastResult = new HyperSearchResult(buffer, newLine);
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(lastResult, false);
                if (lastResult.line == caretLine)
                    selectNode = child;
                bufferNode.add(child);
            }
            lastResult.addOccur(offset + match.start, offset + match.end);
            offset += match.end;
            resultCount++;
        }
    } finally {
        buffer.readUnlock();
    }
    return resultCount;
}