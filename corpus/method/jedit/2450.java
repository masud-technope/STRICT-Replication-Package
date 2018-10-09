//}}}
//{{{ prepareGapForInsertion() method
private void prepareGapForInsertion(int start, int len) {
    moveGapStart(start);
    if (gapLength() < len)
        ensureCapacity(length + len);
}