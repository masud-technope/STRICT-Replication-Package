//}}}
//{{{ searchInSelection() method
private int searchInSelection(Buffer buffer) throws Exception {
    setCancellable(false);
    int resultCount = 0;
    try {
        buffer.readLock();
        for (Selection s : selection) {
            if (s instanceof Selection.Rect) {
                for (int j = s.getStartLine(); j <= s.getEndLine(); j++) {
                    resultCount += doHyperSearch(buffer, s.getStart(buffer, j), s.getEnd(buffer, j));
                }
            } else {
                resultCount += doHyperSearch(buffer, s.getStart(), s.getEnd());
            }
        }
    } finally {
        buffer.readUnlock();
    }
    setCancellable(true);
    return resultCount;
}