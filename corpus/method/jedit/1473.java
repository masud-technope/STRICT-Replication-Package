protected char ReadByte() throws java.io.IOException {
    if (++nextCharInd >= maxNextCharInd)
        FillBuff();
    return nextCharBuf[nextCharInd];
}