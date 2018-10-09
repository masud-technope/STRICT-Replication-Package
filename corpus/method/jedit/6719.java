//}}}
//{{{ setFirstLine() method
/**
	 * Sets the vertical scroll bar position
	 *
	 * @param currentFirstLine the current scroll bar position
	 * @param newFirstLine The to-be scroll bar position
	 */
void setFirstLine(int currentFirstLine, int newFirstLine) {
    int visibleLines = textArea.getVisibleLines();
    if (newFirstLine >= currentFirstLine + visibleLines) {
        this.firstLine.scrollDown(newFirstLine - currentFirstLine);
        textArea.chunkCache.invalidateAll();
    } else if (newFirstLine <= currentFirstLine - visibleLines) {
        this.firstLine.scrollUp(currentFirstLine - newFirstLine);
        textArea.chunkCache.invalidateAll();
    } else if (newFirstLine > currentFirstLine) {
        this.firstLine.scrollDown(newFirstLine - currentFirstLine);
        textArea.chunkCache.scrollDown(newFirstLine - currentFirstLine);
    } else if (newFirstLine < currentFirstLine) {
        this.firstLine.scrollUp(currentFirstLine - newFirstLine);
        textArea.chunkCache.scrollUp(currentFirstLine - newFirstLine);
    } else
        assert true;
    notifyScreenLineChanges();
}