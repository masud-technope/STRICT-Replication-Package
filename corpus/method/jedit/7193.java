public boolean offsetIsBoundary(int offset) {
    return charBreaker.isBoundary(offset - index0Offset);
}