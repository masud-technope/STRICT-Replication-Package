//{{{ reset() method
@Override
public void reset() {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "reset()");
    int currentPhysicalLine = getPhysicalLine();
    int physicalLine = getDisplayManager().getFirstVisibleLine();
    int scrollLine = 0;
    while (physicalLine != -1) {
        if (physicalLine >= currentPhysicalLine)
            break;
        scrollLine += getDisplayManager().getScreenLineCount(physicalLine);
        int nextLine = getDisplayManager().getNextVisibleLine(physicalLine);
        if (nextLine == -1)
            break;
        else
            physicalLine = nextLine;
    }
    setPhysicalLine(physicalLine);
    setScrollLine(scrollLine);
    int screenLines = getDisplayManager().getScreenLineCount(physicalLine);
    if (getSkew() >= screenLines)
        setSkew(screenLines - 1);
    getTextArea().updateScrollBar();
}