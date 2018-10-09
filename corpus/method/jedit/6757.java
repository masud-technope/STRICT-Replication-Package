//}}}
//{{{ physDown() method
// scroll down by physical line amount
void physDown(int amount, int screenAmount) {
    int currentPhysicalLine = getPhysicalLine();
    int currentScrollLine = getScrollLine();
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "physDown() start: " + currentPhysicalLine + ':' + currentScrollLine);
    }
    setSkew(0);
    if (!getDisplayManager().isLineVisible(currentPhysicalLine)) {
        int lastVisibleLine = getDisplayManager().getLastVisibleLine();
        if (currentPhysicalLine > lastVisibleLine)
            setPhysicalLine(lastVisibleLine);
        else {
            int nextPhysicalLine = getDisplayManager().getNextVisibleLine(currentPhysicalLine);
            assert nextPhysicalLine > 0;
            amount -= nextPhysicalLine - currentPhysicalLine;
            moveScrollLine(getDisplayManager().getScreenLineCount(currentPhysicalLine));
            setPhysicalLine(nextPhysicalLine);
        }
    }
    currentPhysicalLine = getPhysicalLine();
    int scrollLines = 0;
    for (; ; ) {
        int nextPhysicalLine = getDisplayManager().getNextVisibleLine(currentPhysicalLine);
        if (nextPhysicalLine == -1)
            break;
        else if (nextPhysicalLine > currentPhysicalLine + amount)
            break;
        else {
            scrollLines += getDisplayManager().getScreenLineCount(currentPhysicalLine);
            amount -= nextPhysicalLine - currentPhysicalLine;
            currentPhysicalLine = nextPhysicalLine;
        }
    }
    setPhysicalLine(currentPhysicalLine);
    moveScrollLine(scrollLines);
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "physDown() end: " + getPhysicalLine() + ':' + getScrollLine());
    }
    // its code
    if (screenAmount < 0)
        scrollUp(-screenAmount);
    else if (screenAmount > 0)
        scrollDown(screenAmount);
}