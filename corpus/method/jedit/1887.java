private final int jj_ntk() {
    if ((jj_nt = token.next) == null)
        return (jj_ntk = (token.next = token_source.getNextToken()).kind);
    else
        return (jj_ntk = jj_nt.kind);
}