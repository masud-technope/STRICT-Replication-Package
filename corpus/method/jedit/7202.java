public int nextOf(int offset) {
    int following = charBreaker.following(offset - index0Offset);
    if (following == BreakIterator.DONE) {
        // responsibility.
        return offset + 1;
    }
    return following + index0Offset;
}