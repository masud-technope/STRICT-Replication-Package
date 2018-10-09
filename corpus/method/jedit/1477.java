public char readChar() throws java.io.IOException {
    if (inBuf > 0) {
        --inBuf;
        if (++bufpos == bufsize)
            bufpos = 0;
        return buffer[bufpos];
    }
    char c;
    if (++bufpos == available)
        AdjustBuffSize();
    if ((buffer[bufpos] = c = ReadByte()) == '\\') {
        UpdateLineColumn(c);
        int backSlashCnt = 1;
        for (; ; ) {
            if (++bufpos == available)
                AdjustBuffSize();
            try {
                if ((buffer[bufpos] = c = ReadByte()) != '\\') {
                    UpdateLineColumn(c);
                    if ((c == 'u') && ((backSlashCnt & 1) == 1)) {
                        if (--bufpos < 0)
                            bufpos = bufsize - 1;
                        break;
                    }
                    backup(backSlashCnt);
                    return '\\';
                }
            } catch (java.io.IOException e) {
                if (backSlashCnt > 1)
                    backup(backSlashCnt);
                return '\\';
            }
            UpdateLineColumn(c);
            backSlashCnt++;
        }
        try {
            while ((c = ReadByte()) == 'u') ++column;
            buffer[bufpos] = c = (char) (hexval(c) << 12 | hexval(ReadByte()) << 8 | hexval(ReadByte()) << 4 | hexval(ReadByte()));
            column += 4;
        } catch (java.io.IOException e) {
            throw new Error("Invalid escape character at line " + line + " column " + column + ".");
        }
        if (backSlashCnt == 1)
            return c;
        else {
            backup(backSlashCnt - 1);
            return '\\';
        }
    } else {
        UpdateLineColumn(c);
        return (c);
    }
}