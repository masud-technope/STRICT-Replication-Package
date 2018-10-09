//}}}
//{{{ showLineRange() method
// for folding
private void showLineRange(int start, int end) {
    if (Debug.FOLD_VIS_DEBUG) {
        Log.log(Log.DEBUG, this, "showLineRange(" + start + ',' + end + ')');
    }
    for (int i = start; i <= end; i++) {
        //XXX
        if (!isLineVisible(i)) {
            // important: not screenLineMgr.getScreenLineCount()
            int screenLines = getScreenLineCount(i);
            if (firstLine.getPhysicalLine() >= i) {
                firstLine.moveScrollLine(screenLines);
            }
            scrollLineCount.moveScrollLine(screenLines);
        }
    }
    /* update fold visibility map. */
    folds.show(start, end);
}