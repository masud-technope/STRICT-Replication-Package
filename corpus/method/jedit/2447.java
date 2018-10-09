//}}}
//{{{ moveGapStart() method
private void moveGapStart(int newStart) {
    int gapEnd = gapEnd();
    int newEnd = gapEnd + (newStart - gapStart);
    if (newStart == gapStart) {
    // nothing to do
    } else if (newStart > gapStart) {
        System.arraycopy(text, gapEnd, text, gapStart, newStart - gapStart);
    } else if (newStart < gapStart) {
        System.arraycopy(text, newStart, text, newEnd, gapStart - newStart);
    }
    gapStart = newStart;
}