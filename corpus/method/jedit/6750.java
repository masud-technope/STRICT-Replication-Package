//}}}
//{{{ scrollDown() method
// scroll down by screen line amount
void scrollDown(int amount) {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "scrollDown()");
    ensurePhysicalLineIsVisible();
    amount += getSkew();
    setSkew(0);
    int physicalLine = getPhysicalLine();
    int screenLinesSum = 0;
    while (amount > 0) {
        int screenLines = getDisplayManager().getScreenLineCount(physicalLine);
        if (amount < screenLines) {
            setSkew(amount);
            break;
        } else {
            int nextLine = getDisplayManager().getNextVisibleLine(physicalLine);
            if (nextLine == -1)
                break;
            boolean visible = getDisplayManager().isLineVisible(physicalLine);
            physicalLine = nextLine;
            if (visible) {
                amount -= screenLines;
                screenLinesSum += screenLines;
            }
        }
    }
    setPhysicalLine(physicalLine);
    moveScrollLine(screenLinesSum);
}