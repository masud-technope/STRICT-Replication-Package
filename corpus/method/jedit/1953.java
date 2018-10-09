/**
		Lookahead for the enhanced for statement.  
		Expect "for" "(" and then see whether we hit ":" or a ";" first.
	*/
boolean isRegularForStatement() {
    int curTok = 1;
    Token tok;
    tok = getToken(curTok++);
    if (tok.kind != FOR)
        return false;
    tok = getToken(curTok++);
    if (tok.kind != LPAREN)
        return false;
    while (true) {
        tok = getToken(curTok++);
        switch(tok.kind) {
            case COLON:
                return false;
            case SEMICOLON:
                return true;
            case EOF:
                return false;
        }
    }
}