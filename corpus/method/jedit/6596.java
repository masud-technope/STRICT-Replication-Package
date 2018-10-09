void moveScrollLine(int numLines) {
    if (numLines == 0)
        return;
    setScrollLine(getScrollLine() + numLines);
}