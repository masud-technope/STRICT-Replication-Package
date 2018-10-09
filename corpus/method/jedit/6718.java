//}}}
//{{{ setFirstPhysicalLine() method
/**
	 * Scroll from a given amount of lines.
	 *
	 * @param amount the amount of lines that must be scrolled
	 * @param skew a skew within the given line
	 */
void setFirstPhysicalLine(int amount, int skew) {
    int currentFirstLine = textArea.getFirstLine();
    if (amount == 0) {
        skew -= this.firstLine.getSkew();
        // its code
        if (skew < 0)
            this.firstLine.scrollUp(-skew);
        else if (skew > 0)
            this.firstLine.scrollDown(skew);
        else {
            // nothing to do
            return;
        }
    } else if (amount > 0)
        this.firstLine.physDown(amount, skew);
    else if (amount < 0)
        this.firstLine.physUp(-amount, skew);
    int firstLine = textArea.getFirstLine();
    int visibleLines = textArea.getVisibleLines();
    if (firstLine == currentFirstLine)
        /* do nothing */
        ;
    else if (firstLine >= currentFirstLine + visibleLines || firstLine <= currentFirstLine - visibleLines) {
        textArea.chunkCache.invalidateAll();
    } else if (firstLine > currentFirstLine) {
        textArea.chunkCache.scrollDown(firstLine - currentFirstLine);
    } else if (firstLine < currentFirstLine) {
        textArea.chunkCache.scrollUp(currentFirstLine - firstLine);
    }
    // we have to be careful
    notifyScreenLineChanges();
}