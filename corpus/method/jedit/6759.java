//}}}
private void scrollVerify() {
    System.err.println("SCROLL_VERIFY");
    int verifyScrollLine = 0;
    int currentPhysicalLine = getPhysicalLine();
    for (int i = 0, n = getDisplayManager().getBuffer().getLineCount(); i < n && i < currentPhysicalLine; i++) {
        if (getDisplayManager().isLineVisible(i))
            verifyScrollLine += getDisplayManager().getScreenLineCount(i);
    }
    int scrollLine = getScrollLine();
    if (verifyScrollLine != scrollLine) {
        RuntimeException ex = new RuntimeException("ScrollLine is " + scrollLine + " but should be " + verifyScrollLine + " diff = " + (verifyScrollLine - scrollLine));
        Log.log(Log.ERROR, this, ex);
    }
}