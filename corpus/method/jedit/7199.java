public int previousOf(int offset) {
    int preceding = charBreaker.preceding(offset - index0Offset);
    if (preceding == BreakIterator.DONE) {
        // responsibility.
        return offset - 1;
    }
    return preceding + index0Offset;
}