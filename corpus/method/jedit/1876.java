private final Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null)
        token = token.next;
    else
        token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
        return token;
    }
    token = oldToken;
    throw generateParseException();
}