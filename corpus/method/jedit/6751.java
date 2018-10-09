//}}}
//{{{ scrollUp() method
// scroll up by screen line amount
void scrollUp(int amount) {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "scrollUp() before:" + this);
    ensurePhysicalLineIsVisible();
    if (amount <= getSkew()) {
        // the amount is less than the skew, so we stay in the same like, just going
        // upper
        setSkew(getSkew() - amount);
    } else {
        // moving to the first screen line of the current physical line
        amount -= getSkew();
        setSkew(0);
        int physicalLine = getPhysicalLine();
        int screenLinesSum = 0;
        while (amount > 0) {
            int prevLine = getDisplayManager().getPrevVisibleLine(physicalLine);
            if (prevLine == -1)
                break;
            // moving to the previous visible physical line
            physicalLine = prevLine;
            int screenLines = getDisplayManager().getScreenLineCount(physicalLine);
            screenLinesSum -= screenLines;
            if (amount < screenLines) {
                setSkew(screenLines - amount);
                break;
            } else {
                amount -= screenLines;
            }
        }
        setPhysicalLine(physicalLine);
        moveScrollLine(screenLinesSum);
    }
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "scrollUp() after:" + this);
}