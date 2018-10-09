private int getNextCharacterOffset(int offset) {
    return new LineCharacterBreaker(this, offset).nextOf(offset);
}