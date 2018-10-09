//}}}
//{{{ scrollUp() method
void scrollUp(int amount) {
    System.arraycopy(lineInfo, 0, lineInfo, amount, textArea.getVisibleLines() - amount);
    for (int i = 0; i < amount; i++) {
        lineInfo[i] = new LineInfo();
    }
    // don't try this at home
    int oldFirstInvalidLine = firstInvalidLine;
    firstInvalidLine = 0;
    updateChunksUpTo(amount);
    firstInvalidLine = oldFirstInvalidLine + amount;
    if (firstInvalidLine > textArea.getVisibleLines())
        firstInvalidLine = textArea.getVisibleLines();
    if (Debug.CHUNK_CACHE_DEBUG) {
        Log.log(Log.DEBUG, this, "f > t.f: only " + amount + " need updates");
    }
    lastScreenLine = lastScreenLineP = -1;
}