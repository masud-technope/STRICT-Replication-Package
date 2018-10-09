//}}}
//{{{ scrollDown() method
void scrollDown(int amount) {
    int visibleLines = textArea.getVisibleLines();
    System.arraycopy(lineInfo, amount, lineInfo, 0, visibleLines - amount);
    for (int i = visibleLines - amount; i < visibleLines; i++) {
        lineInfo[i] = new LineInfo();
    }
    firstInvalidLine -= amount;
    if (firstInvalidLine < 0)
        firstInvalidLine = 0;
    if (Debug.CHUNK_CACHE_DEBUG) {
        System.err.println("f > t.f: only " + amount + " need updates");
    }
    lastScreenLine = lastScreenLineP = -1;
}