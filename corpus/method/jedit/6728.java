//}}}
//{{{ hideLineRange() method
private void hideLineRange(int start, int end) {
    if (Debug.FOLD_VIS_DEBUG) {
        Log.log(Log.DEBUG, this, "hideLineRange(" + start + ',' + end + ')');
    }
    int physicalLine = start;
    if (!isLineVisible(physicalLine))
        physicalLine = getNextVisibleLine(physicalLine);
    int scrollLines = 0;
    while (physicalLine != -1 && physicalLine <= end) {
        int screenLines = getScreenLineCount(physicalLine);
        if (physicalLine < firstLine.getPhysicalLine()) {
            firstLine.setSkew(0);
            firstLine.moveScrollLine(-screenLines);
        }
        scrollLines -= screenLines;
        physicalLine = getNextVisibleLine(physicalLine);
    }
    scrollLineCount.moveScrollLine(scrollLines);
    /* update fold visibility map. */
    folds.hide(start, end);
    if (!isLineVisible(firstLine.getPhysicalLine())) {
        int firstVisible = getFirstVisibleLine();
        if (firstLine.getPhysicalLine() < firstVisible) {
            firstLine.setPhysicalLine(firstVisible);
            firstLine.setScrollLine(0);
        } else {
            firstLine.setPhysicalLine(getPrevVisibleLine(firstLine.getPhysicalLine()));
            firstLine.moveScrollLine(-getScreenLineCount(firstLine.getPhysicalLine()));
        }
    }
}