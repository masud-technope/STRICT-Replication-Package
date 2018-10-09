//}}}
private int getPrevCharacterOffset(int offset) {
    return new LineCharacterBreaker(this, offset).previousOf(offset);
}