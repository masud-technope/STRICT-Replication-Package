private void scan(Segment seg, int offset, int length) {
    int index = scannedIndex;
    if (index >= endIndex) {
        return;
    }
    if (index < beginIndex) {
        int numToSkip = beginIndex - index;
        if (numToSkip >= length) {
            return;
        }
        offset += numToSkip;
        length -= numToSkip;
        index = beginIndex;
    }
    if (index + length > endIndex) {
        length = endIndex - index;
    }
    for (int i = 0; i < length; ++i) {
        char c = seg.array[seg.offset + offset + i];
        if (c == openBracket) {
            result.openCount++;
        } else if (c == closeBracket) {
            if (result.openCount != 0)
                result.openCount--;
            else
                result.closeCount++;
        }
    }
}