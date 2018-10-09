protected void FillBuff() throws java.io.IOException {
    int i;
    if (maxNextCharInd == 4096)
        maxNextCharInd = nextCharInd = 0;
    try {
        if ((i = inputStream.read(nextCharBuf, maxNextCharInd, 4096 - maxNextCharInd)) == -1) {
            inputStream.close();
            throw new java.io.IOException();
        } else
            maxNextCharInd += i;
        return;
    } catch (java.io.IOException e) {
        if (bufpos != 0) {
            --bufpos;
            backup(0);
        } else {
            bufline[bufpos] = line;
            bufcolumn[bufpos] = column;
        }
        throw e;
    }
}