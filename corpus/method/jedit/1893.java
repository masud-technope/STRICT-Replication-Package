public final Token getNextToken() {
    if (token.next != null)
        token = token.next;
    else
        token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    return token;
}