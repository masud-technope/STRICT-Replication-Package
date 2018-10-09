public Token getNextToken() {
    int kind;
    Token specialToken = null;
    Token matchedToken;
    int curPos = 0;
    EOFLoop: for (; ; ) {
        try {
            curChar = input_stream.BeginToken();
        } catch (java.io.IOException e) {
            jjmatchedKind = 0;
            matchedToken = jjFillToken();
            matchedToken.specialToken = specialToken;
            return matchedToken;
        }
        jjmatchedKind = 0x7fffffff;
        jjmatchedPos = 0;
        curPos = jjMoveStringLiteralDfa0_0();
        if (jjmatchedKind != 0x7fffffff) {
            if (jjmatchedPos + 1 < curPos)
                input_stream.backup(curPos - jjmatchedPos - 1);
            if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                matchedToken = jjFillToken();
                matchedToken.specialToken = specialToken;
                return matchedToken;
            } else {
                if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                    matchedToken = jjFillToken();
                    if (specialToken == null)
                        specialToken = matchedToken;
                    else {
                        matchedToken.specialToken = specialToken;
                        specialToken = (specialToken.next = matchedToken);
                    }
                }
                continue EOFLoop;
            }
        }
        int error_line = input_stream.getEndLine();
        int error_column = input_stream.getEndColumn();
        String error_after = null;
        boolean EOFSeen = false;
        try {
            input_stream.readChar();
            input_stream.backup(1);
        } catch (java.io.IOException e1) {
            EOFSeen = true;
            error_after = curPos <= 1 ? "" : input_stream.GetImage();
            if (curChar == '\n' || curChar == '\r') {
                error_line++;
                error_column = 0;
            } else
                error_column++;
        }
        if (!EOFSeen) {
            input_stream.backup(1);
            error_after = curPos <= 1 ? "" : input_stream.GetImage();
        }
        throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
    }
}