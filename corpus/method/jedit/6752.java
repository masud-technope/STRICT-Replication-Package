//}}}
//{{{ ensurePhysicalLineIsVisible() method
void ensurePhysicalLineIsVisible() {
    int physicalLine = getPhysicalLine();
    if (!getDisplayManager().isLineVisible(physicalLine)) {
        if (physicalLine > getDisplayManager().getLastVisibleLine()) {
            setPhysicalLine(getDisplayManager().getLastVisibleLine());
            setScrollLine(getDisplayManager().getScrollLineCount() - 1);
        } else if (physicalLine < getDisplayManager().getFirstVisibleLine()) {
            setPhysicalLine(getDisplayManager().getFirstVisibleLine());
            setScrollLine(0);
        } else {
            int nextLine = getDisplayManager().getNextVisibleLine(physicalLine);
            assert nextLine > 0;
            int screenLineCount = 0;
            screenLineCount = getDisplayManager().getScreenLineCount(nextLine);
            setPhysicalLine(nextLine);
            moveScrollLine(screenLineCount);
        }
    }
}