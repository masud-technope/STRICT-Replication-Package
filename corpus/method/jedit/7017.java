private int getCharacterBoundaryAt(int offset) {
    final LineCharacterBreaker charBreaker = new LineCharacterBreaker(this, offset);
    return charBreaker.offsetIsBoundary(offset) ? offset : charBreaker.previousOf(offset);
}