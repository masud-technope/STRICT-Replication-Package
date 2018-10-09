public String getErrorText() {
    int maxSize = 0;
    for (int i = 0; i < expectedTokenSequences.length; i++) {
        if (maxSize < expectedTokenSequences[i].length)
            maxSize = expectedTokenSequences[i].length;
    }
    String retval = "";
    Token tok = currentToken.next;
    for (int i = 0; i < maxSize; i++) {
        if (i != 0)
            retval += " ";
        if (tok.kind == 0) {
            retval += tokenImage[0];
            break;
        }
        retval += add_escapes(tok.image);
        tok = tok.next;
    }
    return retval;
}