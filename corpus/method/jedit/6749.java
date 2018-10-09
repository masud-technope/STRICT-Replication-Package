//}}}
//{{{ physUp() method
// scroll up by physical line amount
void physUp(int amount, int screenAmount) {
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "physUp() start: " + getPhysicalLine() + ':' + getScrollLine());
    }
    setSkew(0);
    int currentPhysicalLine = getPhysicalLine();
    if (!getDisplayManager().isLineVisible(currentPhysicalLine)) {
        int firstVisibleLine = getDisplayManager().getFirstVisibleLine();
        if (currentPhysicalLine < firstVisibleLine)
            setPhysicalLine(firstVisibleLine);
        else {
            int prevPhysicalLine = getDisplayManager().getPrevVisibleLine(currentPhysicalLine);
            amount -= currentPhysicalLine - prevPhysicalLine;
        }
    }
    currentPhysicalLine = getPhysicalLine();
    int scrollLines = 0;
    for (; ; ) {
        int prevPhysicalLine = getDisplayManager().getPrevVisibleLine(currentPhysicalLine);
        if (prevPhysicalLine == -1)
            break;
        else if (prevPhysicalLine < currentPhysicalLine - amount)
            break;
        else {
            scrollLines -= getDisplayManager().getScreenLineCount(prevPhysicalLine);
            amount -= currentPhysicalLine - prevPhysicalLine;
            currentPhysicalLine = prevPhysicalLine;
        }
    }
    setPhysicalLine(currentPhysicalLine);
    moveScrollLine(scrollLines);
    if (Debug.SCROLL_DEBUG) {
        Log.log(Log.DEBUG, this, "physUp() end: " + getPhysicalLine() + ':' + getScrollLine());
    }
    // its code
    if (screenAmount < 0)
        scrollUp(-screenAmount);
    else if (screenAmount > 0)
        scrollDown(screenAmount);
}