//{{{ reset() method
@Override
public void reset() {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "reset()");
    int scrollLine = 0;
    int physicalLine = getDisplayManager().getFirstVisibleLine();
    while (physicalLine != -1) {
        scrollLine += getDisplayManager().getScreenLineCount(physicalLine);
        physicalLine = getDisplayManager().getNextVisibleLine(physicalLine);
    }
    setPhysicalLine(getDisplayManager().getBuffer().getLineCount());
    setScrollLine(scrollLine);
}